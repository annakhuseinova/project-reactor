package com.annakhuseinova.flux;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture12FluxGenerateCounter {

    public static void main(String[] args) {
        Flux.generate(()-> 1, (counter, sink)-> {
            String country = Util.faker().country().name();
            System.out.println(counter);
            sink.next(country);
            if (counter >= 10 || country.toLowerCase().equals("canada")){
                sink.complete();
            }
           return counter + 1;
        }).subscribe(Util.subscriber());
    }
}
