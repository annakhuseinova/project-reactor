package com.annakhuseinova;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {


    public static Flux<String> getNames(int count){
        return Flux.range(0, count).map( i -> {
            try {
                return getName();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });
    }
//    public static List<String> getNames(int count) throws InterruptedException {
//        List<String> list = new ArrayList<>(count);
//        for (int i = 0; i < count; i++){
//            list.add(getName());
//        }
//        return list;
//    }

    private static String getName() throws InterruptedException {
        Thread.sleep(1000);
        return Util.faker().name().fullName();
    }
}
