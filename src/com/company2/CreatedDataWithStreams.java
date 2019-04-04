package com.company2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class CreatedDataWithStreams {

    public static class Counter {
        int c = 0;

        public int next() {
            return c++;
        }
    }


    public static void Wordcount(Path p, Path p2) {
        try {
            CountWords.CountWordPerFile(p, p2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static File createData(Path p, Counter counter) {

        File file = new File("C:\\Users\\pascal.pairan\\Documents\\indexierung\\", counter.next() + ".txt");

        try (FileWriter fw = new FileWriter(file)) {
            FileInputStream r = new FileInputStream(p.toString());
            StreamTokenizer st = new StreamTokenizer(new InputStreamReader(r));
            st.ordinaryChar('.');
            st.lowerCaseMode(true);

            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                if (st.ttype == StreamTokenizer.TT_WORD) {
                    fw.write(st.sval + "\n");
                }
            }
            System.out.println(p.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }// Fertig

    public static void writePath(File txtfile, Path javafile) {
        try (FileWriter fileWriter = new FileWriter(txtfile, false)) {
            fileWriter.write("/" + javafile.subpath(3, 10).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void CreateAllData(String input) {

        try {
            Stream<Path> javaFiles = CompactClass.findJavaFiles(input);

            Counter counter = new Counter();
            final Map<File, Path> txtFilesjavaFiles = javaFiles.map(javaFile -> Map.entry(createData(javaFile, counter), javaFile)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            // txtFilesjavaFiles.entrySet().forEach(filePathEntry -> writePath(filePathEntry.getKey(), filePathEntry.getValue()));
            txtFilesjavaFiles.keySet().forEach((wC) -> Wordcount(wC.toPath(), txtFilesjavaFiles.get(wC)));
            // txtFilesjavaFiles.entrySet().forEach(filePathEntry -> writePath(filePathEntry.getKey(), filePathEntry.getValue()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
