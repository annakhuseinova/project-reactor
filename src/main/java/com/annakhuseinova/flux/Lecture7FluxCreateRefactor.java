package com.annakhuseinova.flux;

import com.annakhuseinova.NameProducer;
import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture7FluxCreateRefactor {

    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer).subscribe(Util.subscriber());

        Runnable runnable = nameProducer::produce;

        for (int i = 0; i > 10; i++){
            new Thread(runnable).start();
        }
    }
}
