package com.Merging;

import com.Final.FinalTokenizer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;

public class WritingTxtToAll {

    public WritingTxtToAll(){}


    public static void readingAllTxtFilesAndWriting(List<MergedIndexWords> mergedIndexWords)throws IOException {
        FileWriter fileWriter = new FileWriter("C:\\Users\\pascal.pairan\\Documents\\Germerged\\ALL.txt",true);
        PrintWriter pw = new PrintWriter(fileWriter);
        mergedIndexWords.forEach(x->pw.println(x));

      //  System.out.println(mergedIndexWords);
        pw.close();
        fileWriter.close();

    }
}
