package com.PascalSearchEngine;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

//NEU

public class FileTokenizer {
    private static final String DELIMITERS = ". ";

    public static List<String> tokenizeFile(String filename) throws IOException {
        // load everything
        FileInputStream fis = new FileInputStream(filename);
        StreamTokenizer tokenizer = new StreamTokenizer(new InputStreamReader(fis));
        // setup tokenizer
        for (char delimiter : DELIMITERS.toCharArray()) {
            tokenizer.ordinaryChar(delimiter);
        }
        // read everything
        List<String> words = new ArrayList<>();
        String word;
        while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            if (tokenizer.ttype == StreamTokenizer.TT_WORD) {
                word = tokenizer.sval;
                word = word.toLowerCase();
                words.add(word);
            }
        }
        return words;
    }
}
