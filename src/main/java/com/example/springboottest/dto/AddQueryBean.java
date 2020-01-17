package com.example.springboottest.dto;

import java.util.List;

public class AddQueryBean {
    private String userqueryname;
    private String description;
    private String notes;
    private String querytext;
    private String domains;
    private String resultsetsizelimit;
    private String addtype;
    private String envflag;
    private List<TableData> tableData ;

    public String getUserqueryname() {
        return userqueryname;
    }

    public void setUserqueryname(String userqueryname) {
        this.userqueryname = userqueryname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getQuerytext() {
        return querytext;
    }

    public void setQuerytext(String querytext) {
        this.querytext = querytext;
    }

    public String getDomains() {
        return domains;
    }

    public void setDomains(String domains) {
        this.domains = domains;
    }

    public String getResultsetsizelimit() {
        return resultsetsizelimit;
    }

    public void setResultsetsizelimit(String resultsetsizelimit) {
        this.resultsetsizelimit = resultsetsizelimit;
    }

    public List<TableData> getTableData() {
        return tableData;
    }

    public void setTableData(List<TableData> tableData) {
        this.tableData = tableData;
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
        return "AddQueryBean{" +
                "userqueryname='" + userqueryname + '\'' +
                ", description='" + description + '\'' +
                ", notes='" + notes + '\'' +
                ", querytext='" + querytext + '\'' +
                ", domains='" + domains + '\'' +
                ", resultsetsizelimit='" + resultsetsizelimit + '\'' +
                ", addtype='" + addtype + '\'' +
                ", envflag='" + envflag + '\'' +
                ", tableData=" + tableData +
                '}';
    }
}
