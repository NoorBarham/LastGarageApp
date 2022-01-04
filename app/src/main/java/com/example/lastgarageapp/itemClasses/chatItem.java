package com.example.lastgarageapp.itemClasses;

public class chatItem {
    private String textName, textMessage, textHour;

    public chatItem(String textName, String textMessage, String textHour) {
        this.textName = textName;
        this.textMessage = textMessage;
        this.textHour = textHour;
    }


    public String getTextName() {
        return textName;
    }

    public void setTextName(String textName) {
        this.textName = textName;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getTextHour() {
        return textHour;
    }

    public void setTextHour(String textHour) {
        this.textHour = textHour;
    }
}
