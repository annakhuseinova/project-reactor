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
                // behavior triggered when the Flux completes successfully.
                .doOnComplete(()-> System.out.println("doOnComplete"))
                // behavior that will be triggered before the Flux is subscribed to,
                // which should be the first event after assembly time.
                .doFirst(()-> System.out.println("doFirst 1"))
                // add behavior triggered when the Flux emits an item
                .doOnNext(item -> System.out.println("doOnNext: " + item))
                // add behavior triggered when the Flux is being subscribed, that is to say when a Subscription
                // has been produced by the Publisher and is being passed to the Subscriber.onSubscribe(subscription)
                .doOnSubscribe(subscription -> System.out.println("doOnSubscribe"  + subscription))
                // add behavior triggering a LongConsumer when this Flux receives any request
                .doOnRequest(l -> System.out.println("doOnRequest :" + l))
                // add behavior triggered when the Flux completes with an error matching the given exception type
                .doOnError(error -> System.out.println("doOnError: " + error.getMessage()))
                // add behavior triggered when the Flux terminates, either by completing successfully or failing with
                // an error
                .doOnTerminate(()-> System.out.println("doOnTerminate"))
                // add behavior triggered when the Flux is cancelled
                .doOnCancel(()-> System.out.println("doOnCancel"))
                // add behavior triggered after the Flux terminates for any reason, including cancellation
                .doFinally(signalType -> System.out.println("doFinally: " + signalType))
                // Potentially modify the behavior of the whole chain of operators upstream of this one to conditionally
                // clean up elements that get discarded by these operators
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard :" + o))
                .doFirst(()-> System.out.println("Do First 2"))
                .subscribe(Util.subscriber());
    }
}
