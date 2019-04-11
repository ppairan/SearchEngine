package com.Merging;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//NEU

public class TxtTokenizer {

    public static List<String> readTxtfile(String txtfilename) throws IOException {
        FileReader fileReader = new FileReader(txtfilename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        //Pathändern
        List<String> mergedIndexWords = new ArrayList<>();
        String ZoE = bufferedReader.readLine();
        while (ZoE != null) {
            Pattern p = Pattern.compile("(\\d+). (\\w+||\\w+-||\\w+-\\w+) (\\d+)");
            Matcher m = p.matcher(ZoE);
            m.find();
            String word = m.group(2);
            int count = Integer.parseInt(m.group(3));
            ZoE = bufferedReader.readLine();
            //Hier starten für die werte in eine Liste einzu tragen
            mergedIndexWords.add(word);

        }
        return mergedIndexWords;
    }
}
