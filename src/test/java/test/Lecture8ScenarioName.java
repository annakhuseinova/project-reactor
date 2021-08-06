package test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;

public class Lecture8ScenarioName {

    @Test
    public void test1(){
        Flux<String> flux = Flux.just("a", "b", "c");
        StepVerifierOptions scenarioName = StepVerifierOptions.create().scenarioName("alphabets-test");
        StepVerifier.create(flux, scenarioName)
                .expectNextCount(12)
                .verifyComplete();
    }

    // We can set description for each verification step which will be a hint
    @Test
    public void test2(){
        Flux<String> flux = Flux.just("a", "b1", "c");
        StepVerifier.create(flux)
                .expectNext("a")
                // Set a description for the previous verification step
                .as("a-test")
                .expectNext("b")
                // Set a description for the previous verification step
                .as("b-test")
                .expectNext("c")
                // Set a description for the previous verification step
                .as("c-test")
                .verifyComplete();
    }
}
