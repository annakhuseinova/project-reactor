package com.annakhuseinova;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class EmirateFlights {

    public static Flux<String> getFlights(){
        return Flux.range(1, Util.faker().random().nextInt(1, 10))
                .delayElements(Duration.ofSeconds(1))
                .map(item -> "Emirates " + Util.faker().random().nextInt(100, 999))
                .filter(item -> Util.faker().random().nextBoolean());
    }
}
