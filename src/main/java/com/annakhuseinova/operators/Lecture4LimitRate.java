package com.annakhuseinova.operators;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture4LimitRate {

    public static void main(String[] args) {
        Flux.range(1, 1000)
                .log()
                .limitRate(10, 0)
                .subscribe(Util.subscriber());
    }
}
