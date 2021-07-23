package com.annakhuseinova.flux;

import com.annakhuseinova.NameProducer;
import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture13FluxPush {

    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();

        // Flux.push is not thread-safe. It is for single thread producer.
        Flux.push(nameProducer).subscribe(Util.subscriber());
        Runnable runnable = nameProducer::produce;

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
        Util.sleepSeconds(2);
    }
}
