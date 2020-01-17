package com.example.springboottest.dto;

public class Param {
    private String key;
    private String val;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Param{" +
                "key='" + key + '\'' +
                ", val='" + val + '\'' +
                '}';
    }
}
