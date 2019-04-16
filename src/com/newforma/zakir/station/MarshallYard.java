package com.newforma.zakir.station;

import com.newforma.zakir.sort.SortingEngine;

import java.util.ArrayList;

public class MarshallYard {
    private final ArrayList<CarLine> carLines;
    private SortingEngine sortingEngine;

    public MarshallYard(ArrayList<CarLine> carLines,
                        SortingEngine sortingEngine) {
        this.carLines = carLines;
        this.sortingEngine = sortingEngine;
    }

    public void loadTrain(Train train, char destination) {
        sortingEngine.sort(train, destination);
    }

    public int carCount(char dest) {
        return carLines.stream().mapToInt(carLine -> carLine.count(dest)).sum();
    }

}
