package com.annakhuseinova.threadingandschedulers;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lecture3SubscribeOnMultipleItems {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
            printThreadName("create");
            for (int i = 0; i < 4; i++) {
                fluxSink.next(i);
                Util.sleepSeconds(1);
            }
            fluxSink.complete();
        }).doOnNext(i -> printThreadName("next " + i));

        flux.subscribeOn(Schedulers.boundedElastic())
                .subscribe(i -> printThreadName("sub " + i));

        Util.sleepSeconds(5);
    }

    private static void printThreadName(String message){
        System.out.println(message + "\t\t: Thread: " + Thread.currentThread().getName());
    }
}
