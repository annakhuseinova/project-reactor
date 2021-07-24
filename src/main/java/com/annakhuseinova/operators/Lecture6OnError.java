package com.annakhuseinova.operators;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lecture6OnError {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .map(item -> 10/(5 - item))
                .onErrorResume(e -> fallback())
                .onErrorContinue((error, itemThatCausedError)-> {})
                .onErrorReturn(-1)
                .subscribe(Util.subscriber());

    }

    private static Mono<Integer> fallback(){
        return Mono.fromSupplier(()-> Util.faker().random().nextInt(100, 200));
    }
}
