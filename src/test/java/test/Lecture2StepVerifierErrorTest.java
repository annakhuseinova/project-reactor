package test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lecture2StepVerifierErrorTest {

    @Test
    public void test1(){
        Flux<Integer> just = Flux.just(1,2,3);
        Flux<Integer> error = Flux.error(new RuntimeException("oops"));
        Flux<Integer> concatenatedFlux = Flux.concat(just, error);

        StepVerifier.create(concatenatedFlux)
        .expectNext(1, 2, 3)
                // check if the publisher signals error
        .verifyError();
    }
}
