package test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lecture1StepVerifierDemo {

    @Test
    public void test1(){
        Flux<Integer> just = Flux.just(1, 2, 3);

        // we can define expected values by expectNext(...)
        StepVerifier.create(just)
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .verifyComplete();
    }

    // we can define expected values in just one expectNext method
    @Test
    public void test2(){
        Flux<Integer> just = Flux.just(1, 2, 3);

        StepVerifier.create(just)
                .expectNext(1, 2, 3)
                .verifyComplete();
    }
}
