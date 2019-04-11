package com;

import com.Merging.MergingProgramm;
import com.PascalSearchEngine.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class SearchEngineWithObjektorientierung {
    public static void initialize(Path path ,Counter counter){
        try {
            List<IndexedWords> words = FileIndexer.indexFile(path.toString());
            WrintingFromJavaFiles.save(path.toString(),words, counter);
        }catch (IOException e){e.printStackTrace();}
    }



    public static void SearchEngine(String filename) {
        try {
            Counter counter = new Counter();
            Stream<Path> javaFiles = AllStreams.findJavaFiles(filename);
            javaFiles.forEach(i -> initialize(i , counter));
            for (int i = 0; i> filename.length(); i++ ){
                MergingProgramm.readall(filename);
            }

        }catch(IOException e){e.printStackTrace();}
    }
}
