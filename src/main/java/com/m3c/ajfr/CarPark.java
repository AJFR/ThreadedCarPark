package com.m3c.ajfr;

public class CarPark {
    private int spaces;
    private boolean availableSpaces;

    CarPark(int capacity){
        this.spaces = capacity;
        setAvailableSpaces();
    }

    int getSpaces(){
        return spaces;
    }

    void addCar(){
        spaces--;
        setAvailableSpaces();
    }

    void removeCar(){
        spaces++;
        setAvailableSpaces();
    }

    boolean hasAvailableSpaces(){
        return availableSpaces;
    }

    private void setAvailableSpaces(){
        if(spaces>0){
            availableSpaces = true;
        }
        else {
            availableSpaces = false;
        }
    }
}
