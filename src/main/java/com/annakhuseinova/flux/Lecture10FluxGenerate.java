package com.annakhuseinova.flux;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture10FluxGenerate {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            synchronousSink.next(Util.faker().country().name());
            synchronousSink.complete();
        }).subscribe(Util.subscriber());
    }
}
