package com.example.springboottest.po;

public class FQC {
    private String barcode;
    private String testtype;
    private String fqcoperator;
    private String oqcoperator;
    private String operatetime;
    private String result;
    private String defect;
    private String defectcategory;
    private String machinename;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getTesttype() {
        return testtype;
    }

    public void setTesttype(String testtype) {
        this.testtype = testtype;
    }

    public String getFqcoperator() {
        return fqcoperator;
    }

    public void setFqcoperator(String fqcoperator) {
        this.fqcoperator = fqcoperator;
    }

    public String getOqcoperator() {
        return oqcoperator;
    }

    public void setOqcoperator(String oqcoperator) {
        this.oqcoperator = oqcoperator;
    }

    public String getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(String operatetime) {
        this.operatetime = operatetime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDefect() {
        return defect;
    }

    public void setDefect(String defect) {
        this.defect = defect;
    }

    public String getDefectcategory() {
        return defectcategory;
    }

    public void setDefectcategory(String defectcategory) {
        this.defectcategory = defectcategory;
    }

    public String getMachinename() {
        return machinename;
    }

    public void setMachinename(String machinename) {
        this.machinename = machinename;
    }

    @Override
    public String toString() {
        return "FQC{" +
                "barcode='" + barcode + '\'' +
                ", testtype='" + testtype + '\'' +
                ", fqcoperator='" + fqcoperator + '\'' +
                ", oqcoperator='" + oqcoperator + '\'' +
                ", operatetime='" + operatetime + '\'' +
                ", result='" + result + '\'' +
                ", defect='" + defect + '\'' +
                ", defectcategory='" + defectcategory + '\'' +
                ", machinename='" + machinename + '\'' +
                '}';
    }
}
