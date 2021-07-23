package com.annakhuseinova.flux;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture9FluxCreateIssueFix {

    public static void main(String[] args) {

        // Here subscriber will consume first 3 elements, but the data could be further emitted even though the consumer
        // has cancelled its subscription. We can set that data emission will be stopped if the FluxSink has a cancelled
        // subscription

        // Only one instance of FluxSink
        Flux.create(fluxSink -> {
            String country;
            do {
                country = Util.faker().country().name();
                System.out.println("Emitting: " + country);
                fluxSink.next(country);
            } while (!country.toLowerCase().equals("canada") && !fluxSink.isCancelled());
            fluxSink.complete();
        }).subscribe(Util.subscriber());
    }
}
