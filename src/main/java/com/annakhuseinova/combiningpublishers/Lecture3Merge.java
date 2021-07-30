package com.annakhuseinova.combiningpublishers;

import com.annakhuseinova.AmericanAirlines;
import com.annakhuseinova.EmirateFlights;
import com.annakhuseinova.QatarFlights;
import com.annakhuseinova.Util;
import reactor.core.publisher.Flux;

public class Lecture3Merge {

    public static void main(String[] args) {
        Flux<String> mergedFLux = Flux.merge(QatarFlights.getFlights(), EmirateFlights.getFlights(), AmericanAirlines.getFlights());
        mergedFLux.subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }
}
