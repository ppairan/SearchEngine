package com.Merging;

public class MergedIndexWords {
    private String data;
    private String word;
    private int count;

    public MergedIndexWords(String word, String data, int count) {
        this.data = data;
        this.word = word;
        this.count = count;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
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
        return this.word + "= [" + this.data + "," + this.count+"]";
    }
}
