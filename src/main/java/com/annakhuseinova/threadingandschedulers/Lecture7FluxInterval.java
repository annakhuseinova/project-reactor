package com.annakhuseinova.threadingandschedulers;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture7FluxInterval {

    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1)).subscribe(Util.subscriber());
    }
}
