package com.PascalSearchEngine;

import com.Merging.MergedIndexWords;
import com.Merging.TxtTokenizer;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class FileIndexer {
    public FileIndexer() {
    }

    private static HashMap<String, Integer> counting = new HashMap<>();
    private static HashMap<String, String> txtlist = new HashMap<>();

    //Neu
    public static List<IndexedWords> indexFile(String filename) throws IOException {
        List<String> words = FileTokenizer.tokenizeFile(filename);
        Collections.sort(words);


        Stream<String> wordStream = words.stream();
        final Counter counter = new Counter();
        final Stack<IndexedWords> indexedWords = new Stack<>();

        wordStream.forEach(word -> {
            if (indexedWords.empty()) {
                indexedWords.push(new IndexedWords(counter.position, word, 1));
                counter.next();
            } else {
                IndexedWords current = indexedWords.peek();
                if (!current.getWord().equals(word)) {
                    indexedWords.push(new IndexedWords(counter.position, word, 1));
                    counter.next();
                    counting.put(word, current.getCount());
                } else {
                    current.setCount(current.getCount() + 1);
                    counting.put(word, current.getCount());
                }
            }
        });

        return indexedWords;
    }

    public static List<MergedIndexWords> istmiregal(String filename) throws IOException {
        List<String> words = TxtTokenizer.readTxtfile(filename);
        Collections.sort(words);

        File file = new File(filename);
        String path = file.getName().replace(".txt", "");


        Stream<String> wordStream = words.stream();
        final Stack<MergedIndexWords> mergedIndexWords = new Stack<>();

        wordStream.forEach(word -> {
            if (mergedIndexWords.empty()) {
                mergedIndexWords.push(new MergedIndexWords(word, path, counting.get(word)));
            } else {
                MergedIndexWords current = mergedIndexWords.peek();
                if (!current.getWord().equals(word)) {
                    mergedIndexWords.push(new MergedIndexWords(word, path, counting.get(word)));
                }
            }

        });
        System.out.println(mergedIndexWords.toString());
        return mergedIndexWords;
    }

}
