package com.annakhuseinova.mono;

import reactor.core.publisher.Mono;

public class Lecture5RefactoringSupplier {

    public static void main(String[] args) {
        getName();
        getName();
        getName();

    }

    // Here we only build the pipeline but we are not executing as there are no subscribers
    private static Mono<String> getName(){
        System.out.println("entered getName method...");
        return Mono.fromSupplier(()-> {
            System.out.println("Generating name ...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "some random name";
        }).map(String::toUpperCase);
    }
}
