package com.annakhuseinova.batching;

import com.annakhuseinova.BookOrder;
import com.annakhuseinova.RevenueReport;
import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Lecture5Assignment {

    public static void main(String[] args) {
        Set<String> allowedCategories = Set.of("Science fiction", "Fantasy", "Suspense/Thriller");
        bookStream()
                .filter(bookOrder -> allowedCategories.contains(bookOrder.getCategory()))
                .buffer(Duration.ofSeconds(5))
                .map(list -> revenueReport(list))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static RevenueReport revenueReport(List<BookOrder> books){
        Map<String, Double> map = books.stream().collect(Collectors.groupingBy(
                BookOrder::getCategory,
                Collectors.summingDouble(BookOrder::getPrice)
        ));
        return new RevenueReport(map);
    }

    private static Flux<BookOrder> bookStream(){
        return Flux.interval(Duration.ofMillis(200))
                .map(item -> new BookOrder());
    }
}
