package com.newforma.zakir;

import com.newforma.zakir.util.Util;
import com.newforma.zakir.station.Car;
import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DummyContent {

    public static ArrayList<Car> generateDummyCars() {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < getNumberOfCars(); i++) cars.add(new Car(getDestination()));
        return cars;
    }

    public static ArrayList<Car> generateTestCars1() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car('D'));
        cars.add(new Car('C'));
        cars.add(new Car('B'));
        cars.add(new Car('A'));
        return cars;
    }

    public static ArrayList<Car> generateTestCars2() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car('D'));
        cars.add(new Car('E'));
        return cars;
    }

    public static ArrayList<Car> generateTestCars3() {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car('A'));
        cars.add(new Car('G'));
        cars.add(new Car('D'));
        cars.add(new Car('A'));
        cars.add(new Car('G'));
        cars.add(new Car('D'));
        cars.add(new Car('C'));
        return cars;
    }

    public static char getDestination() {
        return (char) (Util.getRandom(7) + 65);
    }

    public static int getNumberOfCars() {
        return Util.getRandom(10) + 1;
    }
}
