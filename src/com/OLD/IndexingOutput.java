package com.OLD;

import java.io.*;
import java.util.Scanner;

public class IndexingOutput {

    public static void filereader(){
        System.out.println("Welche datei soll eingelesen werden");
        System.out.print("Pfad: ");
        Scanner sc = new Scanner(System.in);
        String inputFile = sc.next();

        try {
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);
            StreamTokenizer st = new StreamTokenizer(new BufferedReader(fr));

            st.ordinaryChar('.');
            st.lowerCaseMode(true);
            FileWriter fw = new FileWriter("C:\\Users\\pascal.pairan\\Documents\\indexierung\\hallo.txt",false);

            while(st.nextToken() != st.TT_EOF){
               if (st.ttype == st.TT_WORD){


                   fw.write( st.sval+"\n");
               }
            }
            fw.close();
           Spliting.strintoken();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
