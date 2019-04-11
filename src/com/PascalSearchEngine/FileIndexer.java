package com.PascalSearchEngine;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class FileIndexer {
    public FileIndexer() {}

//Neu
public static List<IndexedWords> indexFile(String filename) throws IOException {
    List<String> words = FileTokenizer.tokenizeFile(filename);
    Collections.sort(words);



    Stream<String> wordStream = words.stream();
    final Counter counter = new Counter();
    final Stack<IndexedWords> indexedWords = new Stack<>();

    wordStream.forEach( word -> {
        if (indexedWords.empty()) {
            indexedWords.push(new IndexedWords(counter.position, word, 1));
            counter.next();
        } else {
            IndexedWords current = indexedWords.peek();
            if (!current.getWord().equals(word)) {
                indexedWords.push(new IndexedWords(counter.position, word, 1));
                counter.next();
            } else {
                current.setCount(current.getCount() + 1);
            }
        }
    });

    return indexedWords;

}
}
