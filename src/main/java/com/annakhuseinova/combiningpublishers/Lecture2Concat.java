package com.annakhuseinova.combiningpublishers;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture2Concat {

    public static void main(String[] args) {
        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.just("c", "d", "e");

        Flux<String> concatenatedFlux = flux1.concatWith(flux2);

        concatenatedFlux.subscribe(Util.subscriber());


        // Another approach for concatenation of fluxes
        Flux<String> anotherConcatenatedFlux = Flux.concat(flux1, flux2);
    }
}
