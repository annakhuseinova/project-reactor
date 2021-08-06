package com.annakhuseinova.sinks;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lecture7SinkReplay {

    Sinks.Many<Object> sink = Sinks.many().replay().all();
    Flux<Object> flux = sink.asFlux();


}
