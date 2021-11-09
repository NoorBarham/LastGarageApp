package com.example.lastgarageapp.itemClasses;

public class chatItem {
    private String messageText, houre;

    public chatItem(String messageText, String houre) {
        this.messageText = messageText;
        this.houre = houre;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getHoure() {
        return houre;
    }

    public void setHoure(String houre) {
        this.houre = houre;
    }
}
