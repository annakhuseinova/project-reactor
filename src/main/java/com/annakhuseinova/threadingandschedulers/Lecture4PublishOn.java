package com.annakhuseinova.threadingandschedulers;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lecture4PublishOn {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
            printThreadName("create");
            for (int i = 0; i < 4 ; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
        }).doOnNext(item -> printThreadName("next " + item));

        flux
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(item -> printThreadName("next " + item))
                .subscribe(value -> printThreadName("sub " + value));
        Util.sleepSeconds(5);
    }

    private static void printThreadName(String message){
        System.out.println(message + "\t\t: Thread: " + Thread.currentThread().getName());
    }
}
