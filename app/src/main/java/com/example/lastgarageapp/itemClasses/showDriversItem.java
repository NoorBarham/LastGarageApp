package com.example.lastgarageapp.itemClasses;

public class showDriversItem {
    private String nameText, lineworkText;

    public showDriversItem(String nameText, String lineworkText) {


        this.nameText = nameText;
        this.lineworkText = lineworkText;
    }


    public void setnameText(String nameText) {
        this.nameText = nameText;
    }

    public void setlineworkText(String lineworkText) {
        this.lineworkText = lineworkText;
    }


    public String getnameText() {
        return nameText;
    }

    public String getlineworkText() {

        return lineworkText;
    }

}
