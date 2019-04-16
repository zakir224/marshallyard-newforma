package test;

import com.newforma.zakir.util.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class UtilTest {

    @Test
    public void randomWithInBound() {
        assertTrue(Util.getRandom(10) > 10);
    }

    @Test
    public void getLastStep() {
        ArrayList<Integer> steps = Util.getSteps(10);
        assertEquals(steps.get(3).intValue(), 1);
    }
}