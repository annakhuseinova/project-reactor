package com.annakhuseinova;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class FluxNameGenerator {

    private List<String> list = new ArrayList<>();

    public Flux<String> generateNames(){
        return Flux.generate(stringSynchronousSink -> {
            String name = Util.faker().name().firstName();
            System.out.println("Generated fresh");
            Util.sleepSeconds(1);
            list.add(name);
            stringSynchronousSink.next(name);
        }).cast(String.class)
                .startWith(getFromCache());
    }

    private Flux<String> getFromCache(){
        return Flux.fromIterable(list);
    }
}
