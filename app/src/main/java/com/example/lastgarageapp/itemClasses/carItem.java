package com.example.lastgarageapp.itemClasses;

public class carItem {
    private String driverName, availabilty,noOfPassenger,arrivalTime;

    public carItem(String driverName, String availabilty, String noOfPassenger, String arrivalTime) {
        this.driverName = driverName;
        this.availabilty = availabilty;
        this.noOfPassenger = noOfPassenger;
        this.arrivalTime = arrivalTime;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getAvailabilty() {
        return availabilty;
    }

    public void setAvailabilty(String availabilty) {
        this.availabilty = availabilty;
    }

    public String getNoOfPassenger() {
        return noOfPassenger;
    }

    public void setNoOfPassenger(String noOfPassenger) {
        this.noOfPassenger = noOfPassenger;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}
