package com.aor.frogger.model.arena;

import com.aor.frogger.model.*;
import com.aor.frogger.model.game.River;
import com.aor.frogger.model.game.Road;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private Frog frog;
    private List<Car> cars;
    private List<Log> logs;
    private List<Leaf> leaves;
    private List<Road> roads;
    private List<River> rivers;

    private List<List<Object>> lines;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
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
            if (car.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isLog(Position position) {
        for (Log log : logs)
            if (log.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isLeaf(Position position) {
        for (Leaf leaf : leaves)
            if (leaf.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isRoad(Position position) {
        for (Road road : roads)
            if(road.getPosition().equals(position)) return true;
        return false;
    }
    public boolean isRiver(Position position) {
        for (River river : rivers)
            if(river.getPosition().equals(position)) return true;
        return false;
    }
/*
    private boolean canFrogMove(Position pos){
        return (pos.getX1() >= 0 && (pos.getX2() - pos.getX1()) == pos.getXdiff() && pos.getX2() <= width && pos.getX2() > pos.getX1() ) &&
                (pos.getY2() >= 0 && (pos.getY1() - pos.getY2()) == pos.getYdiff() && pos.getY1() <= height && pos.getY1() > pos.getY2());
    }
    public void moveFrog(Position position){
        if(canFrogMove(position))
            frog.setPosition(position);
    }
*/ //não percebi até porque o que é relativo a movimentos do frog deve estar na classe FrogController tal como o stor restivo fez. Ainda fizeste um .getXdiff() depois diz o que significa pls

}
