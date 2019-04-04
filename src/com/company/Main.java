package com.company;

import com.company2.CreatedDataWithStreams;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.print("Geben sie den Dateipfad an: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        CreatedDataWithStreams.CreateAllData(input);

    }
}
