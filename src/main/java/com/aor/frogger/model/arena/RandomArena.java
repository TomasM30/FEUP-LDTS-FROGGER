/*
package com.aor.frogger.model.arena;

import com.aor.frogger.model.Car;
import com.aor.frogger.model.Frog;
import com.aor.frogger.model.Leaf;
import com.aor.frogger.model.Log;
import com.aor.frogger.model.game.Dirt;
import com.aor.frogger.model.game.River;
import com.aor.frogger.model.game.Road;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomArena extends ArenaBuilder {
    private final Random rng;

    private final int width;
    private final int height;
    private final int numberOfLogs;
    private final int numberOfLeaves;
    private final List<Integer> numberOfCars;
    private List<List<Object>> lines;

    public RandomArena(int width, int height, List<Integer> numberOfCars, int numberOfLeaves, int numberOfLogs, List<List<Object>> lines) {
        this.rng = new Random();
        this.width = width;
        this.height = height;
        this.numberOfCars = numberOfCars;
        this.numberOfLeaves = numberOfLeaves;
        this.numberOfLogs = numberOfLogs;
        this.lines = lines;
    }

    @Override
    protected List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i<numberOfCars.get(0); i++) {
            cars.add(new Car(rng.nextInt(width-2),1 ));
        }
        return cars;
    }

    @Override
    protected Frog createFrog() {
        return new Frog(width/2,0,3);
    }

    @Override
    protected List<Log> createLogs() {
        List<Log> logs = new ArrayList<>();
        for(int i = 0; i<numberOfLogs; i++) {
            logs.add(new Log(rng.nextInt(width-2),5 ));
        }
        return logs;
    }

    @Override
    protected List<Leaf> createLeaves() {
        return null;
    }

    @Override
    protected List<Road> createRoads() {
        return null;
    }

    @Override
    protected List<Dirt> createDirt() {
        return null;
    }

    @Override
    protected List<River> createRivers() {
        return null;
    }

    @Override
    protected int getWidth() {return width;}

    @Override
    protected int getHeight() {return height;}

    @Override
    protected List<List<Object>> getLines() {return lines; }



    @Override
    protected List<List<Object>> createLines() { // 7 linhas (1 inicio, 2 estrada, 1 a meio, 2 rio, 1 final)
        List<List<Object>> linhas = null;
        List<Frog> frog = null;
        List<Log> logs = null;
        List<Leaf> leaves = null;
        List<Car> cars = null;
        List<Dirt> dirts = null;
        for(int i = 0; i<lines.size(); i++) {
            if(i == 0){ // onde começa o frog
                frog.add(new Frog(width/2,0,3));
                linhas.get(i).add(frog);
                continue;
            }
            if(i==4) { // logs
                for(int j = 0; j<numberOfLogs; j++) {
                    logs.add(new Log(rng.nextInt(width-2), 5));
                }
                linhas.get(i).add(logs);
                continue;
            }
            if(i==5) { // leaves
                for(int j = 0; j<numberOfLeaves;j++){
                    leaves.add(new Leaf(rng.nextInt(width-2), 4) );
                }
                linhas.get(i).add(leaves);
                continue;
            }
            if(i==1) {
                for (int j = 0; j<numberOfCars.get(0); j++) {
                    cars.add(new Car(rng.nextInt(width-2), 1));
                }
                for(int j = 0; j<numberOfCars.get(1);j++) {
                    cars.add(new Car(rng.nextInt(width-2), 2));
                }
            }
        }
        return linhas;
    }

}
*/