package test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Lecture7VirtualTimeTest {

    @Test
    public void test1(){
        StepVerifier.withVirtualTime(this::timeConsumingFlux)
                // Pause the expectation evaluation for a given Duration
                .thenAwait(Duration.ofSeconds(30))
                .expectNext("1a", "2a", "3a", "4a")
                .verifyComplete();     }

    private Flux<String> timeConsumingFlux(){
        return Flux.range(1, 4)
                .delayElements(Duration.ofSeconds(5))
                .map(item -> item + "a");
    }
}
