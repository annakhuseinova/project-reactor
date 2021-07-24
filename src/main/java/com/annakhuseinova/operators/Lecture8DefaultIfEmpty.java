package com.annakhuseinova.operators;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture8DefaultIfEmpty {

    public static void main(String[] args) {
        getOrderNumbers().filter(item -> item > 10)
                .defaultIfEmpty(-100)
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getOrderNumbers(){
        return Flux.range(1, 10);
    }
}
