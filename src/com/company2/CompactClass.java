package com.company2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class CompactClass {

    public static Stream<Path> findJavaFiles(String pathToDir) throws IOException {
        return Files.walk(Paths.get(pathToDir)).filter(f -> f.toString().endsWith(".java") && !f.toString().contains(".mvn"));
    }
//
//    public static void Tokenizer(Path p) {
//        try {
//            FileInputStream r = new FileInputStream(p.toString());
//            Reader br = new InputStreamReader(r);
//            StreamTokenizer st = new StreamTokenizer(new InputStreamReader(r));
//            st.ordinaryChar('.');
//            st.lowerCaseMode(true);
//            FileWriter fw = new FileWriter(p.toString(), true);
//            st.nextToken();
//            while (st.nextToken() != st.TT_EOF) {
//                if (st.ttype == st.TT_WORD) {
//                    fw.write(st.sval + "\n");
//                }
//            }
//            fw.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void searchall() throws Exception {
//        System.out.print("Geben sie den Dateipfad an: ");
//        Scanner sc= new Scanner(System.in);
//        String input = sc.next();
//        //Eingelesener Stream von der Function public static Stream<Path>
//        Stream<Path> javaFiles = findJavaFiles(input);
//        javaFiles.forEach(path -> Tokenizer(path));
//
//
//    }
}
