package com.example.springboottest.dto;

public class logInfo {
    private String ip;
    private String params;
    private String timeconsume;
    private String username;
    private String requesttime;
    private String requestproject;
    private String notes;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getTimeconsume() {
        return timeconsume;
    }

    public void setTimeconsume(String timeconsume) {
        this.timeconsume = timeconsume;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRequesttime() {
        return requesttime;
    }

    public void setRequesttime(String requesttime) {
        this.requesttime = requesttime;
    }

    public String getRequestproject() {
        return requestproject;
    }

    public void setRequestproject(String requestproject) {
        this.requestproject = requestproject;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "logInfo{" +
                "ip='" + ip + '\'' +
                ", params='" + params + '\'' +
                ", timeconsume='" + timeconsume + '\'' +
                ", username='" + username + '\'' +
                ", requesttime='" + requesttime + '\'' +
                ", requestproject='" + requestproject + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
