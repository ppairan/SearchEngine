package com.PascalSearchEngine;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class FileTokenizer {
    private static final String DELIMITERS = ". ";

    public FileTokenizer() {
    }

    public static List<String> tokenizeFile(String filename) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        StreamTokenizer tokenizer = new StreamTokenizer(new InputStreamReader(fis));
        char[] DELIMETERS = ". ".toCharArray();
        int var4 = DELIMETERS.length;

        for(int i = 0; var5 < var4; ++var5) {
            char delimiter = DELIMETERS[var5];
            tokenizer.ordinaryChar(delimiter);
        }

        ArrayList words = new ArrayList();

        while(tokenizer.nextToken() != -1) {
            if (tokenizer.ttype == -3) {
                String word = tokenizer.sval;
                word = word.toLowerCase();
                words.add(word);
            }
        }

        return words;
    }
}
