package com.Final;

import java.io.*;
import java.util.HashMap;

public class FinalTokenizer {

    public static void hashi() throws NullPointerException {
        try{
        FileReader fr = new FileReader("C:\\Users\\pascal.pairan\\Documents\\Germerged\\ALL.txt");
        BufferedReader br = new BufferedReader(fr);


        HashMap<String, String> flist = new HashMap<>();
        String line;
        String data[];

        while((line=br.readLine())!=null) {
            data = line.split(" ");
            String name = data[0];
            String daha = data[1];


            if (!flist.containsKey(name)){
                flist.put(name,daha);

            }//
            else {
                String prevHa = flist.get(name);
                if (!prevHa.contains(daha)) {
                    flist.put(name, prevHa + daha);
                }
            }

        }
            FileWriter fileWriter = new FileWriter("C:\\Users\\pascal.pairan\\Documents\\Germerged\\ALL.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
        for (String lesen : flist.keySet()) {
            printWriter.println( lesen + flist.get(lesen));
        } //für später
            printWriter.close();
        fileWriter.close();
        System.out.println("!fertig!");

    }catch(IOException e){
            e.printStackTrace();
        }
    }
}




//wenn der name schon in der  Hashmap existiert dann