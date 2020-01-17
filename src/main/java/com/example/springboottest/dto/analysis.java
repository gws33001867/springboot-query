package com.example.springboottest.dto;

public class analysis {
    private String queryname;
   // private String time;
    private String envflag;
    private String flag;
    private String qty;

    public String getQueryname() {
        return queryname;
    }

    public void setQueryname(String queryname) {
        this.queryname = queryname;
    }



    public String getEnvflag() {
        return envflag;
    }

    public void setEnvflag(String envflag) {
        this.envflag = envflag;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "analysis{" +
                "queryname='" + queryname + '\'' +
                ", envflag='" + envflag + '\'' +
                ", flag='" + flag + '\'' +
                ", qty='" + qty + '\'' +
                '}';
    }
}
