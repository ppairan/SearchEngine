package com.PascalSearchEngine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WrintingFromJavaFiles {
    public WrintingFromJavaFiles() {
    }

    public static void save(String javafiles ,List<IndexedWords> indexedWord ,Counter counter) {
        try {

            File file = new File("C:\\Users\\pascal.pairan\\Documents\\indexierung\\"+counter.position+".txt");
            counter.next();
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            indexedWord.forEach(pw::println);
            fw.close();
            pw.close();
            System.out.println(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
