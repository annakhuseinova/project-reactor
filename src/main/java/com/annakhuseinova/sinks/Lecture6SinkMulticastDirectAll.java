package com.annakhuseinova.sinks;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class Lecture6SinkMulticastDirectAll {

    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small", "16");
        // directAllOrNothing() method sets the behaviour that if there are no subscribers
        // and some data is pushed by the multicast sink these data will not be buffered
        // until a subscriber subscribes. And that first subscriber will not get that data
        // directAllOrNothing means either all subscribers get the value or none of them gets the value
        Sinks.Many<Object> sink = Sinks.many().multicast().directAllOrNothing();
        Flux<Object> flux = sink.asFlux();
        // By default, when there are no subscribers items pushed by sink will be stored in queue (buffer)
        flux.subscribe(Util.subscriber("sam"));
        flux.delayElements(Duration.ofMillis(200)).subscribe(Util.subscriber("mike"));

        for (int i = 0; i < 100; i++) {
            sink.tryEmitNext(i);
        }

        Util.sleepSeconds(10);
    }
}
