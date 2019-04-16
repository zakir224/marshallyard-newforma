package test;

import com.newforma.zakir.DummyContent;
import com.newforma.zakir.sort.HeuristicSortingEngine;
import com.newforma.zakir.sort.SortingEngine;
import com.newforma.zakir.station.CarLine;
import com.newforma.zakir.station.MarshallYard;
import com.newforma.zakir.station.Train;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class HeuristicSortingEngineTest {

    private SortingEngine sortingEngine;

    @Before
    public void init() {
        ArrayList<CarLine> carLines = new ArrayList<>();
        carLines.add(new CarLine(DummyContent.generateTestCars1()));
        carLines.add(new CarLine(DummyContent.generateTestCars2()));
        sortingEngine = new HeuristicSortingEngine(carLines);
    }

    @Test
    public void sort() {
        Train train = new Train();
        sortingEngine.sort(train, 'C');
        assertEquals(1, train.carCount());
    }
}