package com.OLD;

import java.util.Scanner;

public class Menue {
    public static void mainMenue() {
        System.out.println("Welcome to the Search Engine from Pairan");
        System.out.println("----------------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("Was wollen sie suchen?");
        System.out.println("1. Ganzes Directory             2.Mit Besimmte datei Endungen");
        System.out.println("3. Datein indexieren            4.Datein erstellen");
        System.out.println("5. Programm Schließen");

        Scanner sc = new Scanner(System.in);
        int eingabe = sc.nextInt();

        switch (eingabe) {
            case 1:
                SearchInput.searchall();
                ReturnMenue.returner();
                break;
            case 2:
                SearchInput.singleSearch();
                ReturnMenue.returner();
                break;
            case 3:
                IndexingOutput.filereader();
                ReturnMenue.returner();
                break;
            case 4:
                CreateData.dataCreate();
                ReturnMenue.returner();
                break;
            case 5:
                ReturnMenue.closing();
                break;
            default:
                System.out.println("Sie haben die falsche Zahl benutzt");
                System.out.println("___________________________________");
                System.out.println("Bitte benutzen Sie 1,2 o");
                Menue.mainMenue();
        }
    }

}
