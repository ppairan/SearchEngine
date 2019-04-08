package com;

import com.PascalSearchEngine.AllStreams;
import com.PascalSearchEngine.FileIndexer;
import com.PascalSearchEngine.IndexedWords;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class SearchEngineWithObjektorientierung {
    public static void initialize(Path path){
        try {
            List<IndexedWords> words = FileIndexer.indexFile(path.toString());
        }catch (IOException e){e.printStackTrace();}
    }
    public static void SearchEngine(String filename) {
        try {
            Stream<Path> javaFiles = AllStreams.findJavaFiles(filename);
            javaFiles.forEach(i -> initialize(i));

            String txtpath = "C:\\Users\\pascal.pairan\\Documents\\indexierung";
            Stream<Path> txtfiles = AllStreams.findtxtFiles(txtpath);
            List<String> result = txtfiles.map(x->x.toString()).collect(Collectors.toList());
           // Merging.merging(result);

        }catch(IOException e){e.printStackTrace();}
    }
}
