package com.company;

import com.Final.FinalTokenizer;
import com.Merging.MergingProgramm;
import com.SearchEngineWithObjektorientierung;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        String filename = "C:\\Users\\pascal.pairan\\Downloads\\Html-java-migration-master";
       /* System.out.print("Geben sie den Dateipfad an: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();*/
        String input = "C:\\Users\\pascal.pairan\\Documents\\indexierung\\";
//        SearchEngineWithObjektorientierung.SearchEngine(filename);
       // System.out.println("Java Files fertig ");
        MergingProgramm.readall(input);
//        System.out.println("Text Files fertig gemergd ");
FinalTokenizer.hashi();
        System.out.println("Alles fertig :)");


    }
}
