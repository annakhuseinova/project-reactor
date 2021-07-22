package com.annakhuseinova.flux;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture8FluxTake {

    public static void main(String[] args) {

        // take() operator allows to specify the amount of first elements to take
        Flux.range(1, 10)
                .take(3) // cancels the subscription as soon as the specified amount of items is released
                .subscribe(Util.subscriber());
    }
}
