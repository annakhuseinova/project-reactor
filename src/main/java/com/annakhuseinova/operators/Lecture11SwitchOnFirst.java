package com.annakhuseinova.operators;

import com.annakhuseinova.Person;
import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lecture11SwitchOnFirst {

    public static void main(String[] args) {

        getPerson()
                .switchOnFirst((signal, personFlux)-> {
                    return signal.isOnNext() && signal.get().getAge() > 10 ?
                            personFlux : transformationFunction().apply(personFlux);
                })
                .subscribe(Util.subscriber());
    }

    public static Flux<Person> getPerson(){
        return Flux.range(1, 10)
                .map(item -> new Person())
                .transform(transformationFunction());
    }

    public static Function<Flux<Person>, Flux<Person>> transformationFunction(){
        return flux -> flux.filter(person -> person.getAge() > 10)
                .doOnNext(person -> person.setName(person.getName().toUpperCase()))
                .doOnDiscard(Person.class, person -> System.out.println("Not allowing : " + person));
    }
}
