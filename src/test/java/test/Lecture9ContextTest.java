package test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;
import reactor.util.context.Context;

public class Lecture9ContextTest {

    @Test
    public void test1(){
        StepVerifierOptions options = StepVerifierOptions.create().withInitialContext(Context.of("user", "sam"));
        StepVerifier.create(getWelcomeMessage(), options)
                .expectNext("Welcome")
                .verifyError(RuntimeException.class);
    }

    private Mono<String> getWelcomeMessage(){
        return Mono.deferContextual(context -> {
           if (context.hasKey("user")){
               return Mono.just("Welcome " + context.get("user"));
           } else {
               return Mono.error(new RuntimeException("unauthenticated"));
           }
        });
    }

}
