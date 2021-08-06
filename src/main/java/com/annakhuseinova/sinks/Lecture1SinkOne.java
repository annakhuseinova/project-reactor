package com.annakhuseinova.sinks;

import com.annakhuseinova.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class Lecture1SinkOne {

    public static void main(String[] args) {

        // sinks capable of emitting just 1 value / empty / error
        Sinks.One<Object> sink = Sinks.one();
        Mono<Object> mono = sink.asMono();
        mono.subscribe(Util.subscriber("sam"));
        // the second parameter returns a boolean that defines if the retry should be done
        sink.emitValue("hi", (signal, emitResult)-> {
            System.out.println(signal.name());
            System.out.println(emitResult.name());
            return false;
        });
    }
}
