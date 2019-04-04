package com.company;

import com.company2.CreatedDataWithStreams;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        String filename = "C:\\Users\\pascal.pairan\\IdeaProjects\\project\\src\\main\\java\\com\\example\\project";
        // System.out.print("Geben sie den Dateipfad an: ");
        // Scanner sc = new Scanner(System.in);
        // String input = sc.next();
        String input = filename;
        CreatedDataWithStreams.CreateAllData(input);

    }
}
