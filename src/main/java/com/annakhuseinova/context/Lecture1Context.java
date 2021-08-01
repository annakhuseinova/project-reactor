package com.annakhuseinova.context;

import com.annakhuseinova.Util;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public class Lecture1Context {

    public static void main(String[] args) {
        getWelcomeMessage()
                .contextWrite(Context.of("user", "sam"))
                .subscribe(Util.subscriber());
    }

    private static Mono<String> getWelcomeMessage(){
        return Mono.deferContextual(context -> {
           if (context.hasKey("user")){
               return Mono.just("Welcome " + context.get("user"));
           }
           return Mono.error(new RuntimeException("Unauthenticated"));
        });
    }
}
