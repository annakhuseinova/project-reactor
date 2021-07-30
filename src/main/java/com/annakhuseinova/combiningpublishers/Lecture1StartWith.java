package com.annakhuseinova.combiningpublishers;

import com.annakhuseinova.FluxNameGenerator;
import com.annakhuseinova.Util;

public class Lecture1StartWith {

    public static void main(String[] args) {
        FluxNameGenerator generator = new FluxNameGenerator();
        generator.generateNames()
                .take(2)
                .subscribe(Util.subscriber());
    }
}
