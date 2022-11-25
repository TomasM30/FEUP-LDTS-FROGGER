package com.aor.frogger.model.arena;

import com.aor.frogger.model.Car;
import com.aor.frogger.model.Frog;
import com.aor.frogger.model.Leaf;
import com.aor.frogger.model.Log;
import com.aor.frogger.model.game.River;
import com.aor.frogger.model.game.Road;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setRoads(createRoads());
        arena.setRivers(createRivers());
        arena.setCars(createCars());
        arena.setFrog(createFrog());
        arena.setLeaves(createLeaves());
        arena.setLogs(createLogs());
        arena.setLines(createLines());

        return arena;
    }

    protected abstract List<Car> createCars();
    protected abstract Frog createFrog();
    protected abstract List<Log> createLogs();
    protected abstract List<Leaf> createLeaves();
    protected abstract List<Road> createRoads();
    protected abstract List<River> createRivers();


    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<List<Object>> getLines();

    protected abstract List<List<Object>> createLines();
}