package com.first.lima.activities.farmer.hub.model;

public class Diseasemodel {
    private String diseasename, diseasedesc, diseaseman;
    private int diseaseimage;

    public Diseasemodel(String diseasename, String diseasedesc, String diseaseman, int diseaseimage){
        this.diseasename = diseasename;
        this.diseasedesc = diseasedesc;
        this.diseaseman = diseaseman;
        this.diseaseimage = diseaseimage;
    }

    public String getDiseasename() {
        return diseasename;
    }

    public void setDiseasename(String diseasename) {
        this.diseasename = diseasename;
    }

    public String getDiseasedesc() {
        return diseasedesc;
    }

    public void setDiseasedesc(String diseasedesc) {
        this.diseasedesc = diseasedesc;
    }

    public String getDiseaseman() {
        return diseaseman;
    }

    public void setDiseaseman(String diseaseman) {
        this.diseaseman = diseaseman;
    }

    public int getDiseaseimage() {
        return diseaseimage;
    }

    public void setDiseaseimage(int diseaseimage) {
        this.diseaseimage = diseaseimage;
    }
}
