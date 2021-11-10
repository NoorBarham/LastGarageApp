package com.example.lastgarageapp.itemClasses;

public class notificationItem {
    private String textName,textHour;

    public notificationItem(String textName,String textHour) {
        this.textName = textName;
        this.textHour=textHour;

    }

    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    public String getTextHour() {
        return textHour;
    }

    public void setTextHour(String textHour) {
        this.textHour = textHour;
    }
}
