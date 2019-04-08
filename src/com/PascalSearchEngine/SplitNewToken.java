package com.PascalSearchEngine;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class SplitNewToken {

    public static void strongtoken(Path ps){
        BufferedReader br = null;
        BufferedWriter bw = null;
        //Erstellen eines ArrayList objekten zum Lesen der Hinzugefügten zeilen
        ArrayList<String>newLines = new ArrayList<>();

        try{
            br = new BufferedReader(new FileReader(ps.toString()));
            br.readLine();
            String currentLine = br.readLine();
            while(currentLine != null){
                newLines.add(currentLine);
                currentLine= br.readLine();
            }
            //Sortieren der Liste
            //Collections.sort(newLines);

            //Erstellen eines Bufferedwriter
            bw= new BufferedWriter(new FileWriter(ps.toString(), false));
            bw.newLine();
            for (String line : newLines){
                bw.write(line);
                bw.newLine();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(br != null){
                    br.close();
                }
                if (bw != null){
                    bw.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
