package test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class Lecture4StepVerifierErrorMessage {

    @Test
    public void test3(){
        Flux<Integer> just = Flux.just(1, 2, 3);
        Flux<Integer> error = Flux.error(new RuntimeException("oops"));
        Flux<Integer> concat = Flux.concat(just, error);

        StepVerifier.create(concat)
                .expectNext(1,  2, 3)
                // check that publisher emits error with a particular message
                .verifyErrorMessage("oops");
    }
}
