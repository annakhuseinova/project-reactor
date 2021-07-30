package com.annakhuseinova.repeatandretry;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture1Repeat {

    public static void main(String[] args) {
        getIntegers()
                .repeat(2)
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getIntegers(){
        return Flux.range(1, 3)
                .doOnSubscribe(s -> System.out.println("Subscribed"))
                .doOnComplete(()-> System.out.println("--Completed"));
    }
}
