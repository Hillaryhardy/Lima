package com.first.lima.activities.farmer.hub.model;

public class Marketmodel {
    private String clientName,order,location,status,phone;

    public Marketmodel(String clientName, String order, String location, String status, String phone){
        this.clientName = clientName;
        this.order = order;
        this.location = location;
        this.status = status;
        this.phone = phone;

    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
