package test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lecture3StepVerifierErrorTypeCheck {

    @Test
    public void test2(){
        Flux<Integer> just = Flux.just(1, 2,3);
        Flux<Integer> error = Flux.error(new RuntimeException("oops"));
        Flux<Integer> concat = Flux.concat(just, error);

        StepVerifier.create(concat)
                .expectNext(1, 2, 3)
                // check that publisher emits error of a particular kind
                .verifyError(RuntimeException.class);
    }
}
