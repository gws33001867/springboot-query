package com.example.springboottest.dto;

import java.util.List;

public class QueryParams {
    private String userqueryname;
    private int page;
    private int limit;
    private String envflag;
    private String queryflag;
    private List<Param> param;

    public String getUserqueryname() {
        return userqueryname;
    }

    public void setUserqueryname(String userqueryname) {
        this.userqueryname = userqueryname;
    }

    public List<Param> getParam() {
        return param;
    }

    public void setParam(List<Param> param) {
        this.param = param;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getEnvflag() {
        return envflag;
    }

    public void setEnvflag(String envflag) {
        this.envflag = envflag;
    }

    public String getQueryflag() {
        return queryflag;
    }

    public void setQueryflag(String queryflag) {
        this.queryflag = queryflag;
    }

    @Override
    public String toString() {
        return "QueryParams{" +
                "userqueryname='" + userqueryname + '\'' +
                ", page=" + page +
                ", limit=" + limit +
                ", envflag='" + envflag + '\'' +
                ", queryflag='" + queryflag + '\'' +
                ", param=" + param +
                '}';
    }
}
