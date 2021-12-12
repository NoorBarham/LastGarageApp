package com.example.lastgarageapp.itemClasses;

public class showDriversItem {
    private String nameText, sour,dest;

    public showDriversItem(String nameText, String sour,String dest) {


        this.nameText = nameText;
        this.sour= sour;
        this.dest= dest;

    }


    public void setnameText(String nameText) {
        this.nameText = nameText;
    }

    public void setsourText(String sour) {
        this.sour = sour;
    }


    public void setdestText(String dest) {
        this.dest = dest;
    }



    public String getnameText() {
        return nameText;
    }

    public String getsourText() {

        return sour;
    }
    public String getdestText() {

        return dest;
    }

}
