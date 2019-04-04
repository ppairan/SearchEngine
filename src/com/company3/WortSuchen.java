package com.company3;

import com.company3.IndexedWord;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class WortSuchen {

    public static Stream<Path> txtfind(String pathFromFile) throws Exception {
        return Files.walk(Paths.get(pathFromFile)).filter(f-> f.toString().endsWith(".txt"));
    }

    public static void searching(Path p){
        List<IndexedWord> words = new ArrayList<>();

        System.out.println("In der Datei: "+ p.getFileName());
        System.out.println("Was möchten sie suchen?");
        Scanner sc = new Scanner(System.in);
        String input =sc.next();
        try {

            FileInputStream r = new FileInputStream(p.toString());
            BufferedReader br = new BufferedReader(new InputStreamReader(r));

            String line;
            while((line = br.readLine()) != null){
                IndexedWord word = new IndexedWord(1, line, 1);
                words.add(word);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        for (IndexedWord word : words) {
            if (word.getWort().equals(input)) {
                System.out.println("Deine Suche: "+ input + "exisiert");
            }
        }
    }

    public static void suchen() throws Exception{
        System.out.println("Dateipfad bitte angeben in der sie gesucht werden soll");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        Stream<Path> txtFiles =txtfind(input);
        txtFiles.forEach(p -> searching(p));
    }
}
