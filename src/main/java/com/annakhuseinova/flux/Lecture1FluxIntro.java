package com.annakhuseinova.flux;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture1FluxIntro {

    public static void main(String[] args) {

        Flux.range(3, 10)
                .log()
                .map(i -> Util.faker().name().fullName())
                .subscribe(Util.onNext());
    }
}
