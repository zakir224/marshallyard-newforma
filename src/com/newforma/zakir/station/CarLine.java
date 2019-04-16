package com.newforma.zakir.station;


import java.util.ArrayList;
import java.util.Stack;

public class CarLine {

    private static final int POOL_SIZE = 10;
    private final Stack<Car> cars;

    public CarLine(ArrayList<Car> cars) {
        this.cars = new Stack<>();
        init(cars);
    }

    private void init(ArrayList<Car> cars) {
        cars.forEach(this.cars::push);
    }

    public int count(char destination) {
        return (int) cars.stream().filter(car -> car.getDestination() == destination).count();
    }

    public void push(Car car) {
        if(this.cars.size() == POOL_SIZE)
            throw new RuntimeException("Line can not contain more than 10 cars");

        this.cars.add(car);
    }

    public boolean contains(char dest) {
        return this.cars.contains(new Car(dest));
    }

    public Car pop() {
        if (empty())
            return null;

        return cars.pop();
    }

    public boolean full(){
        return this.cars.size() == POOL_SIZE;
    }

    public boolean empty() {
        if (this.cars == null)
            return false;

        return this.cars.isEmpty();
    }

    public ArrayList<Integer> positions(char dest) {

        Car car = new Car(dest);
        ArrayList<Integer> positions = new ArrayList<>();

        for (int i = this.cars.size() - 1, j = 0; i >= 0; i--, j++) {
            if (car.equals(this.cars.get(i))) {
                positions.add(j);
            }
        }

        return positions;
    }

    public void clear() {
        if (!this.cars.isEmpty()) {
            this.cars.clear();
        }
    }

    public Car top() {
        return this.cars.peek();
    }

    public int count() {
        return this.cars.size();
    }
}
