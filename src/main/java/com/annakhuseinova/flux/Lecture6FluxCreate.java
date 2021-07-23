package com.annakhuseinova.flux;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture6FluxCreate {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
            String country;
            country = Util.faker().country().name();
            synchronousSink.next(country);
            if (country.toLowerCase().equals("canada")){
                synchronousSink.complete();
            }
        }).subscribe(Util.subscriber());
    }
}
