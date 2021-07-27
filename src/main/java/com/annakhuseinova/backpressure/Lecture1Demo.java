package com.annakhuseinova.backpressure;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lecture1Demo {

    public static void main(String[] args) throws InterruptedException {
        Flux.create(fluxSink -> {
            fluxSink.next("some element");
            fluxSink.complete();
        })
                .subscribeOn(Schedulers.boundedElastic()).subscribe(item -> System.out.println(getThreadName()));

        Thread.sleep(5000);
    }

    private static String getThreadName(){
        return Thread.currentThread().getName();
    }
}
