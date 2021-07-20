package com.annakhuseinova.flux;

import com.annakhuseinova.NameGenerator;
import com.annakhuseinova.Util;

public class Lecture3FluxVersusList {

    public static void main(String[] args) throws InterruptedException {
        NameGenerator.getNames(5).subscribe(Util.onNext());
    }
}
