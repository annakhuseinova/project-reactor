package com.annakhuseinova.flux;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lecture4FluxInterval {

    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofSeconds(1)).subscribe(Util.onNext());

        Thread.sleep(5000);
    }
}
