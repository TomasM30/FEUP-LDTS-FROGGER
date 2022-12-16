package com.aor.frogger.model.arena;

import com.aor.frogger.model.*;
import com.aor.frogger.model.game.Dirt;
import com.aor.frogger.model.game.River;
import com.aor.frogger.model.game.Road;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setRoads(createRoads());
        arena.setRivers(createRivers());
        arena.setDirts(createDirt());
        arena.setCars(createCars());
        arena.setBackCar(createBackCars());
        arena.setFrog(createFrog());
        arena.setLogs(createLogs());
        arena.setLilyPads(createLilyPads());
        arena.setLines(createLines());

        return arena;
    }

    protected abstract List<Car> createCars();
    protected abstract List<BackCar> createBackCars();
    protected abstract Frog createFrog();
    protected abstract List<Log> createLogs();
    protected abstract List<LilyPad> createLilyPads();
    protected abstract List<Road> createRoads();

    protected abstract List<Dirt> createDirt();

    protected abstract List<River> createRivers();


    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<List<Object>> getLines();

    protected abstract List<List<Object>> createLines();
}