package com.aor.frogger.model.arena;

import com.aor.frogger.model.Car;
import com.aor.frogger.model.Frog;
import com.aor.frogger.model.Leaf;
import com.aor.frogger.model.Log;

import java.util.List;

public class RandomArena extends ArenaBuilder {

    private final int width;
    private final int height;
    private final List<Integer> numberOfLogs;
    private final int numberOfLeaves;
    private final List<Integer> numberOfCars;
    private List<List<Object>> lines;

    public RandomArena(int width, int height, List<Integer> numberOfCars, int numberOfLeaves, List<Integer> numberOfLogs, List<List<Object>> lines) {
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
    protected List<List<Object>> createLines() { // 7 linhas (1 inicio, 2 estrada, 1 a meio, 2 rio, 1 final)
        List<List<Object>> linhas = null;
        List<Frog> frog = null;
        List<Log> logs = null;
        List<Leaf> leaves = null;
        List<Car> cars = null;
        for(int i = 0; i<lines.size(); i++) {
            if(i == 0){ // onde começa o frog
                frog.add(new Frog(width/2-height/14,width/2+height/14,height/7,0,3));
                linhas.get(i).add(frog);
                continue;
            }
            if(i==4) { // logs
                logs.add(new Log(2,82,height*6/7,height*5/7));
                logs.add(new Log(92,202, height*6/7,height*5/7));
                linhas.get(i).add(logs);
                continue;
            }
            if(i==5) { // leaves
                leaves.add(new Leaf(4,84,height,height*6/7));
                leaves.add(new Leaf(90,210,height,height*6/7));
                linhas.get(i).add(leaves);
                continue;
            }
            if(i>=1 && i<=2) {
                for (int j = height / 7; j < height * 4 / 7; j += height / 7) {
                    cars.add(new Car(2, 82, j + height / 7, j));
                    cars.add(new Car(90,170,j+height/7,j));
                }
            }
        }
        return linhas;
    }
}
