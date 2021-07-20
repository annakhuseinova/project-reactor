package com.annakhuseinova.mono;

import reactor.core.publisher.Mono;

public class Lecture2MonoSubscribe {

    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just("ball").map(String::length).map(integer -> integer / 0);

        // 1
        // mono.subscribe() - we do not provide consumer for the values received from Mono Publisher. But through subscribe()
        // we launch the process of receiving data from Mono Publisher

        // 2. Here we provide implementations for onNext, onError, onComplete methods of Subscriber
        mono.subscribe(
                System.out::println,
                error -> System.out.println(error.getMessage()),
                ()-> System.out.println("Completed")
        );
    }
}
