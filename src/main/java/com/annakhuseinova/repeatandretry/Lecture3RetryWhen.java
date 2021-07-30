package com.annakhuseinova.repeatandretry;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Lecture3RetryWhen {

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        getIntegers()
                .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(2)))
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getIntegers(){
        return Flux.range(1,3)
                .doOnSubscribe(subscription -> System.out.println(subscription))
                .doOnComplete(()-> System.out.println("--Completed"))
                .map(item -> item / 0)
                .doOnError(error -> System.out.println(error));
    }
}
