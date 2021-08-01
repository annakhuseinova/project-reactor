package com.annakhuseinova.combiningpublishers;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture4Zip {

    public static void main(String[] args) {
        Flux.zip(getBody(), getTires(), getEngine())
                .subscribe(Util.subscriber());
    }

    private static Flux<String> getBody(){
        return Flux.range(1, 5)
                .map(item -> "body");
    }

    private static Flux<String> getEngine(){
        return Flux.range(1, 2)
                .map(item -> "engine");
    }

    private static Flux<String> getTires(){
        return Flux.range(1, 6)
                .map(item -> "tires");
    }
}
