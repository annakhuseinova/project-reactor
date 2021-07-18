package com.annakhuseinova;

import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lecture4MonoFromSupplier {

    public static void main(String[] args) {
        // Use Mono.just(...) only when you DO HAVE data already as just will be invoked anyway
        Mono<String> mono = Mono.just(getName());

        //If you are going to calculate anything new based on the subscriber's demand, use fromSupplier()
        Supplier<String> supplierMono = ()-> getName();
        Mono<String> anotherMono = Mono.fromSupplier(supplierMono);

        Callable<String> stringCallable = ()-> getName();
        Mono<String> callableMono = Mono.fromCallable(stringCallable);
    }

    private static String getName(){
        System.out.println("Generating name...");
        return "SomeName";
    }
}
