package com.example.springboottest.po;

public class MachineData {
    private String panel;
    private String panel_seq;
    private String barcode;
    private String machinename;
    private String Machine;
    private String Side;
    private String opttime;
    private String TESTRESULT;
    private String REFERENCEID;
    private String FilePath;

    public String getPanel() {
        return panel;
    }

    public void setPanel(String panel) {
        this.panel = panel;
    }

    public String getPanel_seq() {
        return panel_seq;
    }

    public void setPanel_seq(String panel_seq) {
        this.panel_seq = panel_seq;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getMachinename() {
        return machinename;
    }

    public void setMachinename(String machinename) {
        this.machinename = machinename;
    }

    public String getMachine() {
        return Machine;
    }

    public void setMachine(String machine) {
        Machine = machine;
    }

    public String getSide() {
        return Side;
    }

    public void setSide(String side) {
        Side = side;
    }

    public String getOpttime() {
        return opttime;
    }

    public void setOpttime(String opttime) {
        this.opttime = opttime;
    }

    public String getTESTRESULT() {
        return TESTRESULT;
    }

    public void setTESTRESULT(String TESTRESULT) {
        this.TESTRESULT = TESTRESULT;
    }

    public String getREFERENCEID() {
        return REFERENCEID;
    }

    public void setREFERENCEID(String REFERENCEID) {
        this.REFERENCEID = REFERENCEID;
    }

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String filePath) {
        FilePath = filePath;
    }

    @Override
    public String toString() {
        return "MachineData{" +
                "panel='" + panel + '\'' +
                ", panel_seq='" + panel_seq + '\'' +
                ", barcode='" + barcode + '\'' +
                ", machinename='" + machinename + '\'' +
                ", Machine='" + Machine + '\'' +
                ", Side='" + Side + '\'' +
                ", opttime='" + opttime + '\'' +
                ", TESTRESULT='" + TESTRESULT + '\'' +
                ", REFERENCEID='" + REFERENCEID + '\'' +
                ", FilePath='" + FilePath + '\'' +
                '}';
    }
}
