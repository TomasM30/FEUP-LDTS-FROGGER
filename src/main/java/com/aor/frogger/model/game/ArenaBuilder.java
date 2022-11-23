package com.aor.frogger.model.game;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight(), getLines());

        arena.setFrog(createFrog());
        arena.setCars(createCars());
        arena.setLogs(createLogs());
        arena.setLeaves(createLeaves());

        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<List<Object>> getLines();

    protected abstract List<Car> createCars();

    protected abstract List<Log> createLogs();

    protected abstract Frog createFrog();

    protected abstract List<Leaf> createLeaves();
}