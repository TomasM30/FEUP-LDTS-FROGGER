package com.aor.frogger.model.game;

import java.util.List;

public class RandomArena extends ArenaBuilder{

    private final int width;
    private final int height;
    private final int numberOfLogs;
    private final int numberOfLeaves;
    private final int numberOfCars;
    private List<List<Object>> lines;

    public RandomArena(int width, int height, int numberOfCars, int numberOfLeaves, int numberOfLogs, List<List<Object>> lines) {
        this.width = width;
        this.height = height;
        this.numberOfCars = numberOfCars;
        this.numberOfLeaves = numberOfLeaves;
        this.numberOfLogs = numberOfLogs;
        this.lines = lines;
    }

    @Override
    protected int getWidth() {return width;}

    @Override
    protected int getHeight() {return height;}

    @Override
    protected List<List<Object>> getLines() {return lines; }

    @Override
    protected List<Car> createCars() {
        return null;
    }

    @Override
    protected List<Log> createLogs() {
        return null;
    }

    @Override
    protected Frog createFrog() {
        return null;
    }

    @Override
    protected List<Leaf> createLeaves() {
        return null;
    }
}
