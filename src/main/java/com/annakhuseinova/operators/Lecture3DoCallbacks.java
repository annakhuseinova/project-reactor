package com.annakhuseinova.operators;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

/**
 *   BigDecimal bigDecimal = new BigDecimal(87657);
 *   NumberFormat formatter = NumberFormat.getInstance(new Locale("ru"));
 *   System.out.println(formatter.format(bigDecimal.longValue()));
 * */
public class Lecture3DoCallbacks {
    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            System.out.println("Inside create");
            for (int i = 0; i < 5 ; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
            System.out.println("Completed");
        })
                .doOnComplete(()-> System.out.println("doOnComplete"))
                .doFirst(()-> System.out.println("doFirst"))
                .doOnNext(item -> System.out.println("doOnNext: " + item))
                .doOnSubscribe(subscription -> System.out.println("doOnSubscribe"  + subscription))
                .doOnRequest(l -> System.out.println("doOnRequest :" + l))
                .doOnError(error -> System.out.println("doOnError: " + error.getMessage()))
                .doOnTerminate(()-> System.out.println("doOnTerminate"))
                .doOnCancel(()-> System.out.println("doOnCancel"))
                .doFinally(signalType -> System.out.println("doFinally: " + signalType))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard :" + o))
                .subscribe(Util.subscriber());
    }
}
