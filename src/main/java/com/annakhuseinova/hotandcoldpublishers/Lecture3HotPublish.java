package com.annakhuseinova.hotandcoldpublishers;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lecture3HotPublish {

    public static void main(String[] args) {

        // share() = publish().refCount(1) - share() method internally calls publish() and then refCount(1)
        Flux<String> movieStream =  Flux.fromStream(()-> getMovie()).delayElements(Duration.ofSeconds(2))
                .publish().refCount(1);
        movieStream.subscribe(Util.subscriber("sam"));


        movieStream.subscribe(Util.subscriber("mike"));
    }

    private static Stream<String> getMovie(){
        System.out.println("Got the movie streaming req");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7"
        );
    }
}
