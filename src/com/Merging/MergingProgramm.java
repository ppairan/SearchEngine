package com.Merging;

import com.Final.FinalTokenizer;
import com.PascalSearchEngine.AllStreams;
import com.PascalSearchEngine.FileIndexer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class MergingProgramm {



    public static void initialize2(Path path, Counter2 counter2 ){
        try {
            TxtTokenizer.readTxtfile(path.toString());
            FileIndexer.istmiregal(path.toString());

        }catch (IOException e){e.printStackTrace();}
    }

    public static void readall(String txtfilename) {
        try {
            //Hauptprogramm für das "Mergen"
            Counter2 counter2 = new Counter2();
            try (Stream<Path> txtfiles = AllStreams.findtxtFiles(txtfilename)) {
                txtfiles.forEach(x -> initialize2(x, counter2));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
