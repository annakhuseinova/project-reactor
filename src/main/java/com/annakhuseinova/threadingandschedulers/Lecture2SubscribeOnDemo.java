package com.annakhuseinova.threadingandschedulers;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**
 *   BigDecimal bigDecimal = new BigDecimal(87657);
 *   NumberFormat formatter = NumberFormat.getInstance(new Locale("ru"));
 *   System.out.println(formatter.format(bigDecimal.longValue()));
 * */
public class Lecture2SubscribeOnDemo {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
            printThreadName("create");
            fluxSink.next(1);
        }).doOnNext(item -> printThreadName("next " + item));
        flux
                .doFirst(()-> printThreadName("first2"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(()-> printThreadName("first1"))
                .subscribe(value -> printThreadName("subscription " + value));
        Util.sleepSeconds(5);
    }

    private static void printThreadName(String message){
        System.out.println(message + "\t\t: Thread: " + Thread.currentThread().getName());
    }
}
