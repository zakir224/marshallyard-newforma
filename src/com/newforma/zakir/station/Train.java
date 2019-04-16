package com.newforma.zakir.station;

import java.util.ArrayList;

public class Train {

    private ArrayList<Car> cars;

    public Train() {
        this.cars = new ArrayList<>();
    }

    public Train(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public int carCount() {
        return cars.size();
    }
}
