package com.OLD;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Spliting {

    public static void strintoken() {

        BufferedReader reader = null;
        BufferedWriter writer = null;
        //Create an ArrayList object to hold the lines of input file
        ArrayList<String> lines = new ArrayList<String>();
        try {
            //Creating BufferedReader object to read the input file
            reader = new BufferedReader(new FileReader("C:\\Users\\pascal.pairan\\Documents\\indexierung\\Aufgabe3.txt"));
            //Reading all the lines of input file one by one and adding them into ArrayList
            String currentLine = reader.readLine();
            while (currentLine != null) {
                lines.add(currentLine);
                currentLine = reader.readLine();
            }
            //Sorting the ArrayList
            Collections.sort(lines);
            //Creating BufferedWriter object to write into output file
            writer = new BufferedWriter(new FileWriter("C:\\Users\\pascal.pairan\\Documents\\indexierung\\Aufgabe3.txt", false));
            //Writing sorted lines into output file
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //Closing the resources
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

