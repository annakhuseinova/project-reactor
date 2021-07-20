package com.annakhuseinova.mono;

import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lecture6MonoFromFuture {

    public static void main(String[] args) throws InterruptedException {
        Mono.fromFuture(Lecture6MonoFromFuture::getName).subscribe(System.out::println);
        Thread.sleep(1000);
    }

    private static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(
                ()-> "some random name"
        );
    }
}
