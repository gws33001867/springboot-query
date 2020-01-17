package com.example.springboottest.po;

public class QueryParamters {
    private String userqueryparameterid;
    private String userqueryid;
    private String userqueryparametername;
    private String datatype;
    private String changecount;
    private String paramsequence;
    private String defaultvalue;
    private String label;
    private String placeholder;
    private String key;

    public String getUserqueryparameterid() {
        return userqueryparameterid;
    }

    public void setUserqueryparameterid(String userqueryparameterid) {
        this.userqueryparameterid = userqueryparameterid;
    }

    public String getChangecount() {
        return changecount;
    }

    public void setChangecount(String changecount) {
        this.changecount = changecount;
    }

    public String getUserqueryid() {
        return userqueryid;
    }

    public void setUserqueryid(String userqueryid) {
        this.userqueryid = userqueryid;
    }

    public String getUserqueryparametername() {
        return userqueryparametername;
    }

    public void setUserqueryparametername(String userqueryparametername) {
        this.userqueryparametername = userqueryparametername;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }



    public String getParamsequence() {
        return paramsequence;
    }

    public void setParamsequence(String paramsequence) {
        this.paramsequence = paramsequence;
    }

    public String getDefaultvalue() {
        return defaultvalue;
    }

    public void setDefaultvalue(String defaultvalue) {
        this.defaultvalue = defaultvalue;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "QueryParamters{" +
                "userqueryparameterid='" + userqueryparameterid + '\'' +
                ", userqueryid='" + userqueryid + '\'' +
                ", userqueryparametername='" + userqueryparametername + '\'' +
                ", datatype='" + datatype + '\'' +
                ", changecount='" + changecount + '\'' +
                ", paramsequence='" + paramsequence + '\'' +
                ", defaultvalue='" + defaultvalue + '\'' +
                ", label='" + label + '\'' +
                ", placeholder='" + placeholder + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
