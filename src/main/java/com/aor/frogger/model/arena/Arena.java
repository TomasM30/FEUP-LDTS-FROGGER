package com.aor.frogger.model.arena;

import com.aor.frogger.model.*;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private Frog frog;
    private List<Car> cars;
    private List<Log> logs;
    private List<Leaf> leaves;

    private List<List<Object>> lines;

    public Arena(int width, int height, List<List<Object>> lines) {
        this.width = width;
        this.height = height;
        this.lines = lines;
    }
    public int getWidth() {return this.width;}
    public int getHeight() {return this.height;}
    public List<List<Object>> getLines() {return this.lines;}
    public Frog getFrog() {return this.frog;}
    public List<Car> getCars() {return this.cars;}
    public List<Log> getLogs() {return this.logs;}
    public List<Leaf> getLeaves() {return this.leaves;}

    public void setFrog(Frog a) {this.frog = a;}
    public void setCars(List<Car> cars) {this.cars = cars;}
    public void setLogs(List<Log> logs) {this.logs = logs;}
    public void setLeaves(List<Leaf> leaves) {this.leaves = leaves;}
    public void setLines(List<List<Object>> lines) {this.lines = lines;}

    public boolean isCar(Position position) {
        for (Car car : cars)
            if (car.getPosition().intersects(position))
                return true;
        return false;
    }
    public boolean isLog(Position position) {
        for (Log log : logs)
            if (log.getPosition().intersects(position))
                return true;
        return false;
    }
    public boolean isLeaf(Position position) {
        for (Leaf leaf : leaves)
            if (leaf.getPosition().intersects(position))
                return true;
        return false;
    }

}
