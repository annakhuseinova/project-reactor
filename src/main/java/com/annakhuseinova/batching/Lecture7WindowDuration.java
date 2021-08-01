package com.annakhuseinova.batching;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Lecture7WindowDuration {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        eventStream()
                .window(Duration.ofSeconds(2))
                .flatMap(flux -> saveEvents(flux))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<String> eventStream(){
        return Flux.interval(Duration.ofMillis(500))
                .map(item -> "event" + item);
    }

    // then() - returns a Mono<Integer>  when this Flux completes
    private static Mono<Integer> saveEvents(Flux<String> flux){
        return flux.doOnNext(event -> System.out.println("saving " + event))
                .doOnComplete(()-> {
                    System.out.println("saved this batch");
                    System.out.println("----------------");
                })
                .then(Mono.just(atomicInteger.getAndIncrement()));
    }
}
