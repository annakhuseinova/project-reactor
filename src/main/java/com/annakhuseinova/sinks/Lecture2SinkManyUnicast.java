package com.annakhuseinova.sinks;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lecture2SinkManyUnicast {

    public static void main(String[] args) {
        // handle through which we would push items
        Sinks.Many<Object> sinkMany =  Sinks.many().unicast().onBackpressureBuffer();
        // Handle through which subscribers will receive items
        Flux<Object> flux = sinkMany.asFlux();
        flux.subscribe(Util.subscriber("sam"));
        flux.subscribe(Util.subscriber("mike"));
        sinkMany.tryEmitNext("hi");
        sinkMany.tryEmitNext("how are you?");
        sinkMany.tryEmitNext("?");

    }
}
