package com.annakhuseinova.sinks;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lecture5SinkMulticastDisableHistory {

    public static void main(String[] args) {

        // directAllOrNothing() method sets the behaviour that if there are no subscribers
        // and some data is pushed by the multicast sink these data will not be buffered
        // until a subscriber subscribes. And that first subscriber will not get that data
        Sinks.Many<Object> sink = Sinks.many().multicast().directAllOrNothing();
        Flux<Object> flux = sink.asFlux();
        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you");

        // By default, when there are no subscribers items pushed by sink will be stored in queue (buffer)
        flux.subscribe(Util.subscriber("sam"));
        flux.subscribe(Util.subscriber("mike"));
        sink.tryEmitNext("?");
    }
}
