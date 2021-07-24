package com.annakhuseinova.operators;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture5DelayOperator {

    public static void main(String[] args) {
        Flux.range(1, 100)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());
    }
}
