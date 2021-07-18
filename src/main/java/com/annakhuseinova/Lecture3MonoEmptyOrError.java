package com.annakhuseinova;

import reactor.core.publisher.Mono;

public class Lecture3MonoEmptyOrError {

    public static void main(String[] args) {
        userRepository(1).subscribe(
                System.out::println,
          error -> System.out.println(error.getMessage()),
                ()-> System.out.println("Completed")
        );
    }

    private static Mono<String> userRepository(int userId){
        if (userId == 1){
            return Mono.just("Some name");
        } else if (userId == 2){
            return Mono.empty();
        } else {
            return Mono.error(new RuntimeException("Not in the allowed range"));
        }
    }
}
