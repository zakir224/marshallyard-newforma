package com.newforma.zakir.sort;

import com.newforma.zakir.station.CarLine;
import com.newforma.zakir.station.Train;
import com.newforma.zakir.util.Util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class HeuristicSortingEngine implements SortingEngine {


    private ArrayList<CarLine> carLines;

    public HeuristicSortingEngine(ArrayList<CarLine> carLines) {
        this.carLines = carLines;
    }


    private ArrayList<ArrayList<Integer>> findCars(char dest) {
        ArrayList<ArrayList<Integer>> destCarStats = new ArrayList<>();
        CarLine line;

        for (int i = 0; i < carLines.size(); i++) {
            line = carLines.get(i);
            if (line.contains(dest)) {
                destCarStats.add(i, line.positions(dest));
            } else {
                destCarStats.add(i, new ArrayList<>());
            }
        }

        return destCarStats;
    }

    @Override
    public void sort(Train train, char dest) {
        ArrayList<ArrayList<Integer>> carPositions = findCars(dest);
        PriorityQueue<CarLine> movingDestination = getMovableLines(dest);
        int nextSortingLine = getNextSortingLine(carPositions);
        CarLine destLine = movingDestination.remove();

        while (nextSortingLine != -1) {
            CarLine sourceLine = carLines.get(nextSortingLine);
            int distance = carPositions.get(nextSortingLine).get(0) - 0;
            ArrayList<Integer> steps = Util.getSteps(distance);
            for (Integer step : steps) {
                for (int j = 0; j < step; j++) {
                    if (destLine.full()) {
                        destLine = movingDestination.remove();
                    }
                    destLine.push(sourceLine.pop());
                }
            }
            train.addCar(sourceLine.pop());
            carPositions.get(nextSortingLine).remove(0);
            nextSortingLine = getNextSortingLine(carPositions);
        }
    }

    private PriorityQueue<CarLine> getMovableLines(char dest) {
        PriorityQueue<CarLine> preferredDestination = new PriorityQueue<>(
                Comparator.comparingInt(o -> o.count(dest)));

        preferredDestination.addAll(carLines);

        return preferredDestination;
    }

    private int getNextSortingLine(ArrayList<ArrayList<Integer>> carPositions) {
        Stream<ArrayList<Integer>> listStream = carPositions.stream().filter(carPos -> carPos.size() > 0);

        if(listStream.count() == 0)
            return -1;

        int listIndex = Integer.MAX_VALUE;

        for (int i = 0; i < carPositions.size(); i++) {
            ArrayList<Integer> positions = carPositions.get(i);
            if (positions.size() > 0 && positions.get(0) < listIndex) {
                listIndex = i;
            }
        }

        return listIndex;
    }
}
