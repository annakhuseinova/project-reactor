package com.annakhuseinova.combiningpublishers;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture3ConcatDelayError {

    public static void main(String[] args) {
        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.error(new RuntimeException("oops"));
        Flux<String> flux3 = Flux.just("c", "d", "e");
        Flux<String> flux = Flux.concatDelayError(flux1, flux2, flux3);
        flux.subscribe(Util.subscriber());
    }
}
