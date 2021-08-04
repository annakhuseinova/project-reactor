package test;

import com.annakhuseinova.BookOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

public class Lecture6AssertTest {

    // Expect an element and consume it with the given consumer, usually performing assertions on it (eg. using Hamcrest,
    // AssertJ or JUnit assertion methods). Alias for consumeNextWith(Consumer) for better discoverability of that use case
    @Test
    public void test1(){
        Mono<BookOrder> mono = Mono.fromSupplier(BookOrder::new);
        StepVerifier.create(mono).assertNext(bookOrder -> Assertions.assertNotNull(bookOrder.getAuthor()))
        .verifyComplete();
    }

    @Test
    public void test2(){
        Mono<BookOrder> mono = Mono.fromSupplier(()-> new BookOrder()).delayElement(Duration.ofSeconds(3));
        StepVerifier.create(mono)
                .assertNext(bookOrder -> Assertions.assertNotNull(bookOrder.getAuthor()))
                // verify that data get emitted within the given timespan
                .verifyTimeout(Duration.ofSeconds(2));
    }
}
