package com.newforma.zakir;

import com.newforma.zakir.sort.HeuristicSortingEngine;
import com.newforma.zakir.station.Car;
import com.newforma.zakir.station.CarLine;
import com.newforma.zakir.station.MarshallYard;
import com.newforma.zakir.station.Train;
import com.newforma.zakir.util.Util;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<CarLine> carLines = new ArrayList<>(6);
        carLines.add(new CarLine(DummyContent.generateDummyCars()));
        carLines.add(new CarLine(DummyContent.generateDummyCars()));
        carLines.add(new CarLine(DummyContent.generateDummyCars()));

        MarshallYard marshallYard = new MarshallYard(carLines, new HeuristicSortingEngine(carLines));
        Train trainToNewYork = new Train();
        marshallYard.loadTrain(trainToNewYork, 'B');
    }



}
