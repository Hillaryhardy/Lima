package com.first.lima.activities.farmer.hub.model;

public class LabourModel {
     private String name,servicedesc,location,lease,phone;

     public LabourModel(String name, String servicedesc, String location, String lease, String phone){
         this.name = name;
         this.servicedesc = servicedesc;
         this.location = location;
         this.lease = lease;
         this.phone = phone;
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServicedesc() {
        return servicedesc;
    }

    public void setServicedesc(String servicedesc) {
        this.servicedesc = servicedesc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLease() {
        return lease;
    }

    public void setLease(String lease) {
        this.lease = lease;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
