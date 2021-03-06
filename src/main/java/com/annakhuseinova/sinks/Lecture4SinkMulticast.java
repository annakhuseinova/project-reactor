package com.annakhuseinova.sinks;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lecture4SinkMulticast {

    public static void main(String[] args) {
        Sinks.Many<Object> sink = Sinks.many().multicast().onBackpressureBuffer();
        Flux<Object> flux = sink.asFlux();
        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you");

        // By default, when there are no subscribers items pushed by sink will be stored in queue (buffer)
        flux.subscribe(Util.subscriber("sam"));
        flux.subscribe(Util.subscriber("mike"));
        sink.tryEmitNext("?");
    }
}
