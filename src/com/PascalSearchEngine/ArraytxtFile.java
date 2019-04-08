package com.PascalSearchEngine;

import java.util.ArrayList;
import java.util.List;

public class ArraytxtFile {
    private String filename;

    private List<String> list = new ArrayList<>();

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;

    }

    public ArraytxtFile(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
