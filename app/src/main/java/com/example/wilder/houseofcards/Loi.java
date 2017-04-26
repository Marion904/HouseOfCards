package com.example.wilder.houseofcards;

/**
 * Created by wilder on 05/04/17.
 */

public class Loi {

    public static final int DROITE = 1;
    public static final int GAUCHE = 2;
    public static final int CENTRE = 3;

    private String text;
    private int orientation;

    public Loi(String text, int orientation){
        this.text = text;
        this.orientation=orientation;
    }
    public String getText(){
        return this.text;
    }
    public int getOrientation(){
        return this.orientation;
    }
}
