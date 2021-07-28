package com.annakhuseinova.threadingandschedulers;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lecture6Parallel {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .parallel(2)
                .runOn(Schedulers.boundedElastic())
                .doOnNext(item -> printThreadName("next " + item))
                .subscribe(value -> printThreadName("sub " + value));

        Util.sleepSeconds(5);
    }

    private static void printThreadName(String message){
        System.out.println(message + "\t\t: Thread: " + Thread.currentThread().getName());
    }
}
