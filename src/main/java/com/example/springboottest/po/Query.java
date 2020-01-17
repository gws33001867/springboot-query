package com.example.springboottest.po;

public class Query {
    private String userqueryid;

    private Long changehistoryid;

    private Long changecount;

    private String description;

    private String notes;

    private String userqueryname;

    private String resultsetsizelimit;

    private Integer activestatus;

    private String querytext;

    private String envflag;

    private String addtype;

    public String getUserqueryid() {
        return userqueryid;
    }

    public void setUserqueryid(String userqueryid) {
        this.userqueryid = userqueryid;
    }

    public Long getChangehistoryid() {
        return changehistoryid;
    }

    public void setChangehistoryid(Long changehistoryid) {
        this.changehistoryid = changehistoryid;
    }

    public Long getChangecount() {
        return changecount;
    }

    public void setChangecount(Long changecount) {
        this.changecount = changecount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getUserqueryname() {
        return userqueryname;
    }

    public void setUserqueryname(String userqueryname) {
        this.userqueryname = userqueryname == null ? null : userqueryname.trim();
    }

    public String getResultsetsizelimit() {
        return resultsetsizelimit;
    }

    public void setResultsetsizelimit(String resultsetsizelimit) {
        this.resultsetsizelimit = resultsetsizelimit;
    }

    public Integer getActivestatus() {
        return activestatus;
    }

    public void setActivestatus(Integer activestatus) {
        this.activestatus = activestatus;
    }

    public String getQuerytext() {
        return querytext;
    }

    public void setQuerytext(String querytext) {
        this.querytext = querytext == null ? null : querytext.trim();
    }

    public String getEnvflag() {
        return envflag;
    }

    public void setEnvflag(String envflag) {
        this.envflag = envflag;
    }

    public String getAddtype() {
        return addtype;
    }

    public void setAddtype(String addtype) {
        this.addtype = addtype;
    }

    @Override
    public String toString() {
        return "Query{" +
                "userqueryid='" + userqueryid + '\'' +
                ", changehistoryid=" + changehistoryid +
                ", changecount=" + changecount +
                ", description='" + description + '\'' +
                ", notes='" + notes + '\'' +
                ", userqueryname='" + userqueryname + '\'' +
                ", resultsetsizelimit='" + resultsetsizelimit + '\'' +
                ", activestatus=" + activestatus +
                ", querytext='" + querytext + '\'' +
                ", envflag='" + envflag + '\'' +
                ", addtype='" + addtype + '\'' +
                '}';
    }
}