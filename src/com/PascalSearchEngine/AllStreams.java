package com.PascalSearchEngine;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllStreams {

    public static Stream<Path> findJavaFiles(String pathToDir) throws IOException {
        return Files.walk(Paths.get(pathToDir)).filter(f -> f.toString().endsWith(".java") && !f.toString().contains(".mvn"));
    }

    public static Stream<Path> findtxtFiles(String pathFromtxt) throws IOException {
        return Files.walk(Paths.get(pathFromtxt)).filter(f->f.toString().endsWith(".txt"));
    }
}
