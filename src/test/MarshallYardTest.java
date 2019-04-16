package test;

import com.newforma.zakir.DummyContent;
import com.newforma.zakir.sort.HeuristicSortingEngine;
import com.newforma.zakir.station.CarLine;
import com.newforma.zakir.station.MarshallYard;
import com.newforma.zakir.station.Train;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MarshallYardTest {

    private MarshallYard marshallYard;

    @Before
    public void init() {
        ArrayList<CarLine> carLines = new ArrayList<>(6);
        carLines.add(new CarLine(DummyContent.generateDummyCars()));
        carLines.add(new CarLine(DummyContent.generateDummyCars()));
        carLines.add(new CarLine(DummyContent.generateDummyCars()));
        carLines.add(new CarLine(DummyContent.generateDummyCars()));
        carLines.add(new CarLine(DummyContent.generateDummyCars()));

        marshallYard = new MarshallYard(carLines, new HeuristicSortingEngine(carLines));

    }

    @Test
    public void checkEmptyYardAfterLoading() {
        Train trainToNewYork = new Train();
        marshallYard.loadTrain(trainToNewYork, 'B');
        assertEquals(0, marshallYard.carCount('B'));
    }

    @Test
    public void checkAllCarsLoadedToTrain() {
        Train trainToNewYork = new Train();
        int carCountBeforeLoading = marshallYard.carCount('B');
        marshallYard.loadTrain(trainToNewYork, 'B');
        assertEquals(carCountBeforeLoading, trainToNewYork.carCount());
    }
}