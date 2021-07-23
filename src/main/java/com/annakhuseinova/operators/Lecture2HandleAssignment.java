package com.annakhuseinova.operators;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture2HandleAssignment {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            synchronousSink.next(country);
        }).map(Object::toString).handle((item, synchronousSink)-> {
            synchronousSink.next(item);
            System.out.println("Emitting");
            if (item.toLowerCase().equals("canada")){
                synchronousSink.complete();
            }
        }).subscribe(Util.subscriber());
    }
}
