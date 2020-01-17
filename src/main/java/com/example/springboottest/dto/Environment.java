package com.example.springboottest.dto;

public class Environment {

    private String id;
    private String environmentflag;
    private String environmentname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnvironmentflag() {
        return environmentflag;
    }

    public void setEnvironmentflag(String environmentflag) {
        this.environmentflag = environmentflag;
    }

    public String getEnvironmentname() {
        return environmentname;
    }

    public void setEnvironmentname(String environmentname) {
        this.environmentname = environmentname;
    }

    @Override
    public String toString() {
        return "Environment{" +
                "id='" + id + '\'' +
                ", environmentflag='" + environmentflag + '\'' +
                ", environmentname='" + environmentname + '\'' +
                '}';
    }
}
