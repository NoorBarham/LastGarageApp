package com.example.lastgarageapp.itemClasses;

public class carItem {
    private String driverName, availability,noOfPassenger,arrivalTime;
    private String carNumber;
    public carItem(String carNumber, String driverName, String availability, String noOfPassenger, String arrivalTime) {
        this.carNumber=carNumber;
        this.driverName = driverName;
        this.availability = availability;
        this.noOfPassenger = noOfPassenger;
        this.arrivalTime = arrivalTime;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
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
