package com.annakhuseinova.batching;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture8GroupBy {

    public static void main(String[] args) {
        Flux.range(1,30)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(i -> 1 % 2)
                .subscribe(groupedFlux -> process(groupedFlux, groupedFlux.key()));

        Util.sleepSeconds(60);
    }

    private static void process(Flux<Integer> flux, int key){
        System.out.println("Called");
        flux.subscribe(integer -> System.out.println("Key : " + key + ", Item : " + integer));
    }
}
