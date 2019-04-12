package com.PascalSearchEngine;

public class IndexedWords {
    private int position;
    private String word;
    private int count;

    public IndexedWords(int position, String word, int count) {
        this.position = position;
        this.word = word;
        this.count = count;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String toString() {
        return this.position + ". " + this.word + " " + this.count +",";
    }
}

