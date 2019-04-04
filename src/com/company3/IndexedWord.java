package com.company3;

public class IndexedWord {

    private int stelle;
    private String wort;
    private int vorkommen;

    public IndexedWord(int stelle, String wort, int vorkommen) {
        this.stelle = stelle;
        this.wort = wort;
        this.vorkommen = vorkommen;
    }

    public int getStelle() {
        return stelle;
    }

    public void setStelle(int stelle) {
        this.stelle = stelle;
    }

    public String getWort() {
        return wort;
    }

    public void setWort(String wort) {
        this.wort = wort;
    }

    public int getVorkommen() {
        return vorkommen;
    }

    public void setVorkommen(int vorkommen) {
        this.vorkommen = vorkommen;
    }
}
