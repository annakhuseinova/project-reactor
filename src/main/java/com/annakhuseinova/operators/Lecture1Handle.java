package com.annakhuseinova.operators;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture1Handle {

    public static void main(String[] args) {
        Flux.range(0, 10).handle((integer, synchronousSink) -> {
            synchronousSink.next(integer);
        }).subscribe(Util.subscriber());
    }
}
