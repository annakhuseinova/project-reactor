package com.annakhuseinova.threadingandschedulers;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture1ThreadDemo {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
            printThreadName("create");
            fluxSink.next(1);
        }).doOnNext(item -> printThreadName("next " + item));
        flux.subscribe(value -> printThreadName("subscription " + value));
        Runnable runnable = ()-> flux.subscribe(value -> printThreadName("sub "+ value));

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(5);
    }

    private static void printThreadName(String message){
        System.out.println(message + "\t\t: Thread: " + Thread.currentThread().getName());
    }
}
