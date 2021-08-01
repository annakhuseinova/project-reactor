package com.annakhuseinova.batching;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture4OverlapAndDrop {

    public static void main(String[] args) {
        eventStream()
                .buffer(3)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<String> eventStream(){
        return Flux.interval(Duration.ofMillis(300))
                .map(item -> "event " + item);
    }
}
