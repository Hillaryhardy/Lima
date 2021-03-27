package com.first.lima.activities.farmer.hub.model;

public class Financemodel {
    private String institutionName, institutionDesc, institutionPhone;
    private int institutionImage;


    public Financemodel(String institutionName, String institutionDesc, String institutionPhone, int institutionImage){
        this.institutionName = institutionName;
        this.institutionDesc = institutionDesc;
        this.institutionPhone = institutionPhone;
        this.institutionImage = institutionImage;

    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstitutionDesc() {
        return institutionDesc;
    }

    public void setInstitutionDesc(String institutionDesc) {
        this.institutionDesc = institutionDesc;
    }

    public int getInstitutionImage() {
        return institutionImage;
    }

    public String getInstitutionPhone() {
        return institutionPhone;
    }

    public void setInstitutionPhone(String institutionPhone) {
        this.institutionPhone = institutionPhone;
    }

    public void setInstitutionImage(int institutionImage) {
        this.institutionImage = institutionImage;
    }
}
