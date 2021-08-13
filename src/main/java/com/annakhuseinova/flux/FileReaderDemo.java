package com.annakhuseinova.flux;

import com.annakhuseinova.Util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReaderDemo {

    public static void main(String[] args) {
        FileReaderService readerService = new FileReaderService();
        Path path = Paths.get("src/main/resources/assignment/file4.txt");
        readerService.read(path).subscribe(Util.subscriber());
    }
}
