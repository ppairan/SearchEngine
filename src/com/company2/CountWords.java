package com.company2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class CountWords {
    //Maximale Anzahl von Wörtern in einer TXT Datei
    static final int Maximum = 4000;
    //Speicher für die zugehoerigen Wörter
    private static String[] words = new String[Maximum];
    //Speicher für die zugehürige Häufigheit
    private static int[] counts = new int[Maximum];
    //Anzahl der Wörter
    private static int countingWords = 0;
    //Zeichen die wörter trennen
    private static final String Delimiter = " \r\n\t,.:;!'\"";

    private static int readWhiteSpaces(String zeile, int startIndex) {
        int curIndex = startIndex;
        while (curIndex < zeile.length() && Delimiter.indexOf(zeile.charAt(curIndex)) > 0) {
            curIndex++;
        }
        return curIndex;
    }

    private static void countingAllWords(String zeile) {
        int index = 0;

        //Trennzeichen überlesen
        index = readWhiteSpaces(zeile, index);
        while (index < zeile.length()) {
            int sIndex = index;
            int eIndex = index;
            while (eIndex < zeile.length() && Delimiter.indexOf(zeile.charAt(eIndex)) < 0) {
                eIndex++;
            }
            // End index(eIndex) steht auf ersten Whitespace nach dem Wort
            String wort = zeile.substring(sIndex, eIndex);
            index = eIndex;
            //Wort suchen
            int wortIndex = -1;
            int curPos = 0;
            while (wortIndex < 0 && curPos < countingWords) {
                String cur = words[curPos];
                if (cur.equalsIgnoreCase(wort)) {
                    //Wort gefunden. Häufigkeit erhöhen
                    counts[curPos]++;
                    wortIndex++;
                }
                curPos++;
            }
            if (wortIndex < 0) {
                //Neu eintragen wenn noch nicht vorhanden ist
                words[countingWords] = wort;
                counts[countingWords] = 1;
                countingWords++;
            }
            //Trennung mit Whitespaces überlesen
            index = readWhiteSpaces(zeile, index);
        }
    }

    public static void CountWordPerFile(Path p, Path p2) {
        String path = p.toString();
        String zeile;
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            zeile = br.readLine();


            while (zeile != null) {
                if (!zeile.startsWith("/")) {
                    countingAllWords(zeile);
                }
                zeile = br.readLine();

            }


            FileWriter fw = new FileWriter(path,false);
            fw.write("\\" +p2.subpath(3, 10).toString()+'\n');
            for (int i = 0; i < countingWords; i++) {
                fw.write(i + ". " + words[i] + " , " + counts[i] + '\n');

            }
            fw.close();
            words = new String[Maximum];
            counts = new int[Maximum];
            countingWords = 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
