package com.example.lastgarageapp.itemClasses;


public class garageItem {
    private String cityName, adminName, fromHoure, toHoure, location;

    public garageItem(String cityName, String adminName, String fromHoure, String toHoure, String location) {
        this.cityName = cityName;
        this.adminName = adminName;
        this.fromHoure = fromHoure;
        this.toHoure = toHoure;
        this.location = location;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setFromHoure(String fromHoure) {
        this.fromHoure = fromHoure;
    }

    public void setToHoure(String toHoure) {
        this.toHoure = toHoure;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCityName() {
        return cityName;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getFromHoure() {
        return fromHoure;
    }

    public String getToHoure() {
        return toHoure;
    }

    public String getLocation() {
        return location;
    }
}
