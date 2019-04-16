package test;

import com.newforma.zakir.station.Car;
import com.newforma.zakir.station.CarLine;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class CarLineTest {

    private CarLine carLine;

    @Before
    public void initialize() {
        carLine = new CarLine(new ArrayList<>());
    }

    @Test
    public void getCountHasItems() {
        carLine.push(new Car('A'));
        carLine.push(new Car('B'));
        carLine.push(new Car('C'));
        carLine.push(new Car('C'));
        assertEquals(2, carLine.count('C'));
    }

    @Test
    public void getCountEmpty() {
        carLine.clear();
        assertEquals(0, carLine.count('I'));
    }

    @Test
    public void addOneItem() {
        carLine.push(new Car('K'));
        assertEquals('K', carLine.top().getDestination());
    }

    @Test
    public void containsReturnsTrue() {
        carLine.push(new Car('A'));
        assertTrue(carLine.contains('A'));
    }

    @Test
    public void pop() {
        carLine.push(new Car('B'));
        assertEquals('B', carLine.pop().getDestination());
    }

    @Test
    public void isEmpty() {
        carLine.clear();
        assertEquals(0,carLine.count());
    }

    @Test
    public void getPositions() {
        carLine.clear();
        carLine.push(new Car('A'));
        carLine.push(new Car('B'));
        carLine.push(new Car('C'));
        carLine.push(new Car('C'));
        carLine.push(new Car('D'));
        assertEquals( 2, carLine.count('C'));
    }

    @Test
    public void pushWithException() {

    }
}