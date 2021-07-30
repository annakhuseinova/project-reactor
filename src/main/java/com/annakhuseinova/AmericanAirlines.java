package com.annakhuseinova;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class AmericanAirlines {

    public static Flux<String> getFlights(){
        return Flux.range(1, Util.faker().random().nextInt(1, 5))
                .delayElements(Duration.ofSeconds(1))
                .map(item -> "AA " + Util.faker().random().nextInt(100, 999))
                .filter(item -> Util.faker().random().nextBoolean());
    }
}
