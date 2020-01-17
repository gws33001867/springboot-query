package com.example.springboottest.dto;

import com.example.springboottest.po.QueryParamters;

import java.util.List;

public class UpdateBean {
    private String userqueryid;
    private String userqueryname;
    private String resultsetsizelimit;
    private String querytext;
    private String description;
    private String envflag;
    private List<QueryParamters> params;

    public String getUserqueryid() {
        return userqueryid;
    }

    public void setUserqueryid(String userqueryid) {
        this.userqueryid = userqueryid;
    }

    public String getUserqueryname() {
        return userqueryname;
    }

    public void setUserqueryname(String userqueryname) {
        this.userqueryname = userqueryname;
    }

    public String getResultsetsizelimit() {
        return resultsetsizelimit;
    }

    public void setResultsetsizelimit(String resultsetsizelimit) {
        this.resultsetsizelimit = resultsetsizelimit;
    }

    public String getQuerytext() {
        return querytext;
    }

    public void setQuerytext(String querytext) {
        this.querytext = querytext;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnvflag() {
        return envflag;
    }

    public void setEnvflag(String envflag) {
        this.envflag = envflag;
    }

    public List<QueryParamters> getParams() {
        return params;
    }

    public void setParams(List<QueryParamters> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "UpdateBean{" +
                "userqueryid='" + userqueryid + '\'' +
                ", userqueryname='" + userqueryname + '\'' +
                ", resultsetsizelimit='" + resultsetsizelimit + '\'' +
                ", querytext='" + querytext + '\'' +
                ", description='" + description + '\'' +
                ", envflag='" + envflag + '\'' +
                ", params=" + params +
                '}';
    }

}
