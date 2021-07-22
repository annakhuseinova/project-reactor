package com.annakhuseinova.flux;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture6FluxCreate {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            String country;
            do {
                country = Util.faker().country().name();
                fluxSink.next(country);
            } while (!country.toLowerCase().equals("canada"));
            fluxSink.complete();
        }).subscribe(Util.subscriber());
    }
}
