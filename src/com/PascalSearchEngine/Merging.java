package com.PascalSearchEngine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Stack;

public class Merging {

    public static void merging(List<String> list) {
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\pascal.pairan\\Documents\\Germerged\\All.txt");
            list.forEach(l -> reading(l));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


/*


    public static void reading(String listelesen) {
        try {
            FileReader fileReader = new FileReader(listelesen);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> buffer = new Stack<>();
            while (bufferedReader.readLine() != null) {
                buffer.add(bufferedReader.readLine());

            }
            System.out.println(((Stack<String>) buffer).peek());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
*/
}
