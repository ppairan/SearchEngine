package com.Final;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FinalTokenizer {
  private  static HashMap<String, String> flist = new HashMap<>();

    public static void filecleaner() throws IOException{
        FileWriter fileWriter = new FileWriter("C:\\Users\\pascal.pairan\\Documents\\Germerged\\ALL.txt");
        fileWriter.write("");
        fileWriter.close();

    }

    public static void sortByKeys() throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\Users\\pascal.pairan\\Documents\\Germerged\\Fertig.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        TreeMap<String, String> sorted = new TreeMap<>();

        sorted.putAll(flist);

        for (Map.Entry<String, String> entry : sorted.entrySet()) {
            printWriter.println(entry);
        }
        printWriter.close();
        fileWriter.close();
    }

    public static void hashi() throws NullPointerException {

        try {

            FileReader fr = new FileReader("C:\\Users\\pascal.pairan\\Documents\\Germerged\\ALL.txt");
            BufferedReader br = new BufferedReader(fr);

//            filecleaner();

            String line;
            String [] data;



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
                            flist.put(name,daha+prevHa );
                        }
                    }

                }
            FileWriter fileWriter = new FileWriter("C:\\Users\\pascal.pairan\\Documents\\Germerged\\ALL.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (String lesen : flist.keySet()) {
               System.out.println(lesen + flist.get(lesen));
            } //für später
            printWriter.close();
            fileWriter.close();

            sortByKeys();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}