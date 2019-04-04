package com.OLD;

import java.util.Scanner;

public class ReturnMenue {
    public static void returner(){
        System.out.println("Wollen sie zum Menü zurück?");
        System.out.println("Ja oder Nein");
        Scanner sc = new Scanner(System.in);
        String jaNein = sc.next();

        if (jaNein.equalsIgnoreCase("ja")){
            Menue.mainMenue();
        }else{
            System.out.println("Das Programm schließt sich in ......");
            for (int i = 5; i > 0; --i){
                System.out.println(i);
                try {
                    Thread.sleep(500);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.exit(1);
        }
    }

    public static void closing(){
        System.out.println("Wollen sie wirklich beenden?");
        Scanner scanner = new Scanner(System.in);
        String close = scanner.next();

        if (close.equalsIgnoreCase("ja")){
            System.out.println("Das Programm schließt sich in ......");
            for (int i = 5; i > 0; --i){
                System.out.println(i);
                try {
                    Thread.sleep(500);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.exit(1);
        }else{
            Menue.mainMenue();
        }
    }
}
