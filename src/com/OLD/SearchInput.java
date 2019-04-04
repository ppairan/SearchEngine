package com.OLD;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchInput {

    public static void searchall() {

        System.out.println("Geben sie bitte an welchen Ordner sie durchsuchen wollen");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        try (Stream<Path> walk = Files.walk(Paths.get(input))) {

            List<String> result = walk.filter(Files::isDirectory)
                    .map(x -> x.toString()).collect(Collectors.toList());

            result.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void singleSearch() {
        System.out.println("Geben sie bitte an welchen Ordner sie durchsuchen wollen");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println("Nun bitte noch die datei endungen was sie haben wollen");
        String fend = sc.next();


        try (Stream<Path> walk = Files.walk(Paths.get(input))) {

            List<String> result = walk.map(x -> x.toString())
                    .filter(f -> f.endsWith("."+fend)).collect(Collectors.toList());

            result.forEach(System.out::println);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
