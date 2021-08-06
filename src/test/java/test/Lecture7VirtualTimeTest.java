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

    @Test
    public void test2(){
        StepVerifier.withVirtualTime(()-> timeConsumingFlux())
                // First we expect subscription
                .expectSubscription()
                // then nothing should be happening for 4 seconds
                .expectNoEvent(Duration.ofSeconds(4))
                // then await for 20 seconds before items are coming
                .thenAwait(Duration.ofSeconds(20))
                .expectNext("1a", "2a", "3a", "4a")
                .verifyComplete();
    }

    private Flux<String> timeConsumingFlux(){
        return Flux.range(1, 4)
                .delayElements(Duration.ofSeconds(5))
                .map(item -> item + "a");
    }
}
