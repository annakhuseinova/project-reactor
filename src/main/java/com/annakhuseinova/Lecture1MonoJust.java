package com.annakhuseinova;

import reactor.core.publisher.Mono;

public class Lecture1MonoJust {

    public static void main(String[] args) {

        // publisher
        Mono<Integer> integerMono = Mono.just(1);

        // In reactive programming nothing happens until you subscribe
        integerMono.subscribe(element -> System.out.println("Received: " + element));

    }
}
