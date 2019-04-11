package com.Merging;

import java.io.IOException;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class TxtIndexer {

    public static List<MergedIndexWords> indexFile(String txtfilename) throws IOException {
        List<String> mergedIndexWords = TxtTokenizer.readTxtfile(txtfilename);


        Stream<String> listenstream = mergedIndexWords.stream();

        final Counter2 counter2 = new Counter2();
        final Stack<MergedIndexWords> mergedIndexWordsStack = new Stack<>();


        String path = txtfilename.substring(txtfilename.lastIndexOf("\\"));

        listenstream.forEach(list -> {
            if (mergedIndexWordsStack.empty()) {
                mergedIndexWordsStack.push(new MergedIndexWords(list, path.replace(".txt", "").replace("\\", ""), 1));
                counter2.next();
            } else {
                MergedIndexWords current = mergedIndexWordsStack.peek();
                if (!current.getWord().equals(list)) {
                    mergedIndexWordsStack.push(new MergedIndexWords(list, path.replace(".txt", "").replace("\\", ""), 1));
                    counter2.next();
                }else{
                    current.setCount(current.getCount() + 1);
                }
            }
        });
        return mergedIndexWordsStack;
    }

}



