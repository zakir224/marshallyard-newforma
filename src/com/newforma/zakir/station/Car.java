package com.newforma.zakir.station;

public class Car {

    private char destination;

    public Car(char destination) {
        setDestination(destination);
    }

    public char getDestination() {
        return destination;
    }

    public void setDestination(char destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Car))
            return false;
        return this.destination == ((Car) obj).destination;
    }
}
