package com.annakhuseinova;

import reactor.core.publisher.Mono;

public class Lecture7MonoFromRunnable {

    public static void main(String[] args) {
        // Why create a Mono from Runnable if Runnable does not return any value? We might want to trigger some operation
        // at the end of the task defined by Runnable. Do something on completion of Runnable task.
        Mono.fromRunnable(timeConsumingProcess()).subscribe(
                System.out::println,
                Throwable::getMessage,
                ()-> {
                    System.out.println("Completed");
                }
        );

    }

    private static Runnable timeConsumingProcess(){
        return ()-> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Operation completed");
        };
    }
}
