package com.annakhuseinova.hotandcoldpublishers;

import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lecture5HotPublishCache {

    public static void main(String[] args) {

        /*
        * Flux.range(1, 10).cache(int numberOfElementsToCache) - cache(int numberOfItemsToCache) method allows
        *  to turn Flux into a hot publisher and cache the items given to some subscribe for further fast release
        * to other subscribers. If the elements have been released with a delay for previous subscriber and cached,
        *  for the next subscriber cached elements will be given immediately. We can control the number of cached items
         * */
        Flux<String> movieStream =  Flux.fromStream(()-> getMovie()).delayElements(Duration.ofSeconds(1))
                .cache();

        Util.sleepSeconds(2);
        movieStream.subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(10);
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
