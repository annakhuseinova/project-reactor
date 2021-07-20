package com.annakhuseinova.flux;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lecture5MonoToFlux {

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("a");
        Flux<String> flux = Flux.from(mono);
        flux.subscribe(Util.onNext());
        Flux.range(1, 10).next();
    }

    private static void doSomething(Flux<String> flux){

    }
}
