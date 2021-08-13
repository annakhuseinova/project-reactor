package com.annakhuseinova.mono;

import com.annakhuseinova.Util;

public class FileServiceDemo {

    public static void main(String[] args) {
        FileService.read("file1.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        FileService.write("file3.txt", "This is file 3")
        .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
