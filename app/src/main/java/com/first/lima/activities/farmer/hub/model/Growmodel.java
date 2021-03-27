package com.first.lima.activities.farmer.hub.model;

public class Growmodel {
    private String catname,catdescription;
    private int image;

    public Growmodel(String catname, String catdescription, int image) {
        this.catname = catname;
        this.image = image;
        this.catdescription = catdescription;


    }

    public int getImage() {
        return image;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public String getCatdescription() {
        return catdescription;
    }

    public void setCatdescription(String catdescription) {
        this.catdescription = catdescription;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
