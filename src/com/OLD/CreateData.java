package com.OLD;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreateData {
    public static void dataCreate() {
        System.out.println("Wie soll die datei heißen?");
        System.out.print("Dateiname: ");
        Scanner sc = new Scanner(System.in);
        String filename = sc.next();
        System.out.println("Wie soll die Datei enden?");
        String path = "C:\\Users\\pascal.pairan\\Documents\\indexierung\\";
        System.out.println("Datei ohne punkt eingeben");
        String end = sc.next();


        try {
            File file = new File(path + filename + "." + end);
            if (file.createNewFile()) {
                System.out.println("Datei wurde erstellt");
                System.out.println("Ihre Datei findet: " + file);

            } else {
                System.out.println("Datei wurde nicht erstellt weil sie schon existiert!");
                System.out.println(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path p = new Path();
        p.setFileName(filename+"."+end);
        p.setPathName(path);
        System.out.println(p.getFileName());
        System.out.println(p.getPathName());
    }


}
