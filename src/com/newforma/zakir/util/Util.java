package com.newforma.zakir.util;

import java.util.ArrayList;
import java.util.Random;

public class Util {


    private Util() {
    }

    public static int getRandom(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    public static ArrayList<Integer> getSteps(int distance) {
        ArrayList<Integer> integerSteps = new ArrayList<>();
        if (distance <= 3) {
            integerSteps.add(distance);
        } else {
            int maxStepCount = distance / 3;
            for (int i = 0; i < maxStepCount; i++) {
                integerSteps.add(3);
            }
            integerSteps.add(distance % 3);
        }

        return integerSteps;
    }
}
