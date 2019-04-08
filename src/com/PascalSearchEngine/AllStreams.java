package com.PascalSearchEngine;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllStreams {

    public static Stream<Path> findJavaFiles(String pathToDir) throws IOException {
        return Files.walk(Paths.get(pathToDir)).filter(f -> f.toString().endsWith(".java") && !f.toString().contains(".mvn"));
    }

    public static void findtxtFiles(String pathFromtxt) throws IOException {
        try (Stream<Path> walk = Files.walk(Paths.get(pathFromtxt))) {

            List<String> result = walk.map(x -> x.toString())
                    .filter(f -> f.endsWith(".txt")).collect(Collectors.toList()).add();


        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
