package com.annakhuseinova.operators;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture9SwitchIfEmpty {

    public static void main(String[] args) {
        getOrderNumbers().filter(item -> item > 10)
                .switchIfEmpty(fallback())
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getOrderNumbers(){
        return Flux.range(1, 10);
    }

    private static Flux<Integer> fallback(){
        return Flux.range(1, 10);
    }
}
