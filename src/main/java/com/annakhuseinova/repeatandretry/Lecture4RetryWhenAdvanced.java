package com.annakhuseinova.repeatandretry;

import com.annakhuseinova.Util;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

public class Lecture4RetryWhenAdvanced {

    public static void main(String[] args) {
        orderService(Util.faker().business().creditCardNumber())
                .retryWhen(Retry.from(
                    flux -> flux.doOnNext(retrySignal -> {
                        System.out.println(retrySignal.totalRetries());
                        System.out.println(retrySignal.failure());
                    })
                        .handle((retrySignal, synchronousSink) -> {
                          if (retrySignal.failure().getMessage().equals("500")){
                              synchronousSink.next(1);
                          }
                        })
                ))
                .subscribe(Util.subscriber());
    }

    private static Mono<String> orderService(String creditCardNumber){
        return Mono.fromSupplier(()-> {
           processPayment(creditCardNumber);
           return Util.faker().idNumber().valid();
        });
    }

    private static void processPayment(String creditCardNumber){
        int random = Util.faker().random().nextInt(1, 10);
        if (random < 8){
            throw new RuntimeException("500");
        } else if (random < 10){
            throw new RuntimeException("404");
        }
    }
}
