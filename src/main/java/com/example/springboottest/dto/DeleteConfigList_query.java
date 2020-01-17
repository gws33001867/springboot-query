package com.example.springboottest.dto;

import java.util.List;

public class DeleteConfigList_query {
    private String configlistid;
    private List<String> lists;

    public String getConfiglistid() {
        return configlistid;
    }

    public void setConfiglistid(String configlistid) {
        this.configlistid = configlistid;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "DeleteConfigList_query{" +
                "configlistid='" + configlistid + '\'' +
                ", lists=" + lists +
                '}';
    }
}
