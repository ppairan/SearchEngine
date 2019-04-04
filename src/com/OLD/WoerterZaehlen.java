package com.OLD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class WoerterZaehlen {
    //Maximale Anzahl der Wörter
    private static int MAX_WOERTER = 4000;

    // Speicher für die Maximale wörter
    private static String[] woerter = new String[MAX_WOERTER];

    //Speicher für die Häufigkeit der Wörter
    private static int[] haufigkeit = new int[MAX_WOERTER];

    //Anzahl der Wörter
    private static int woerterZahl = 0;

    //Zeichen, welche Wörter getrennt werden

    private static final String Delimiter = " \r\n\t,.:;!'()\"";

    public static int readWhiteSpace(String zeile, int startIndex) {
        int curIndex = startIndex;

        while (curIndex < zeile.length() && Delimiter.indexOf(zeile.charAt(curIndex)) >= 0) {
            curIndex++;
        }
        return curIndex;
    }

    public static void zaehleWoerter(String zeile) {
        int index = 1;
        index = readWhiteSpace(zeile, index);
        while (index < zeile.length()) {
            int startIndex = index;
            int endIndex = index;
            while (endIndex < zeile.length() && Delimiter.indexOf(zeile.charAt(endIndex)) < 0) {
                endIndex++;
            }
            //EndIndex steht im Whitespace an erster stelle
            String wort = zeile.substring(startIndex, endIndex);
            index = endIndex;
            //wortsuchen
            int wortIndex = -1;
            int curPos = 0;
            while (wortIndex < 0 && curPos < woerterZahl) {
                String cur = woerter[curPos];
                if (cur.equalsIgnoreCase(wort)) {
                    haufigkeit[curPos]++;
                    wortIndex = curPos;
                }
                curPos++;
            }
            if (wortIndex < 0) {
                //Neu eintragen wenn es das wort noch nicht gibt
                woerter[woerterZahl] = wort;
                haufigkeit[woerterZahl] = 1;
                woerterZahl++;
            }
            index = readWhiteSpace(zeile, index);
        }
    }

    public static void ausgabe(Path p) {
        String zeile;
        try {
            FileReader fr = new FileReader(p.toString());
            BufferedReader br = new BufferedReader(fr);
            zeile = br.readLine();
            while (zeile != null) {
                zaehleWoerter(zeile);
                zeile = br.readLine();
            }
            FileWriter fw = new FileWriter(p.toString(), false);
            for (int i = 0; i < woerterZahl; i++) {
                fw.write(i + ". " + woerter[i] + " , " + haufigkeit[i] + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
