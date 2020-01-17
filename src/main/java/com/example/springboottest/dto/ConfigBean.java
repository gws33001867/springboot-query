package com.example.springboottest.dto;

import com.example.springboottest.po.Query;

import java.util.List;

public class ConfigBean {

    private String label;
    private String configlistid;
    private String envflag;
    private List<Query> children;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getConfiglistid() {
        return configlistid;
    }

    public void setConfiglistid(String configlistid) {
        this.configlistid = configlistid;
    }

    public List<Query> getChildren() {
        return children;
    }

    public void setChildren(List<Query> children) {
        this.children = children;
    }

    public String getEnvflag() {
        return envflag;
    }

    public void setEnvflag(String envflag) {
        this.envflag = envflag;
    }

    @Override
    public String toString() {
        return "ConfigBean{" +
                "label='" + label + '\'' +
                ", configlistid='" + configlistid + '\'' +
                ", envflag='" + envflag + '\'' +
                ", children=" + children +
                '}';
    }
}
