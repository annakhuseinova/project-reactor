package com.annakhuseinova.backpressure;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lecture3Latest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("reactor.bufferSize.small", "16");

        Flux.create(fluxSink -> {
            for (int i = 0; i < 501; i++) {
                fluxSink.next(i);
                System.out.println("Pushed : " + i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            fluxSink.complete();
        }).onBackpressureLatest()
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(item -> {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                })
                .subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }
}
