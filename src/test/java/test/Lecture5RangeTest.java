package test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lecture5RangeTest {

    @Test
    public void test1(){
        Flux<Integer> range = Flux.range(1, 50);
        StepVerifier.create(range)
                .expectNextCount(50)
                .verifyComplete();
    }

    // Consume further onNext signals as long as they match a predicate
    @Test
    public void test2(){
        Flux<Integer> range = Flux.range(1, 50);
        StepVerifier.create(range)
                .thenConsumeWhile(item -> item < 100)
                .verifyComplete();
    }
}
