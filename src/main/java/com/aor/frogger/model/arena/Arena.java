package com.aor.frogger.model.arena;

import com.aor.frogger.model.*;
import com.aor.frogger.model.game.*;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private Frog frog;
    private List<Car> cars;
    private List<BackCar> backcars;
    private List<Log> logs;
    private List<LilyPad> lilyPads;
    private List<Road> roads;
    private List<River> rivers;
    private List<Dirt> dirts;

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
    public List<BackCar> getBackCar() {return this.backcars;}
    public List<Log> getLogs() {return this.logs;}
    public List<LilyPad> getLilyPads(){return this.lilyPads;}
    public List<River> getRivers() {return this.rivers;}
    public List<Road> getRoads() {return this.roads;}
    public List<Dirt> getDirts(){return this.dirts;}

    public void setFrog(Frog a) {this.frog = a;}
    public void setCars(List<Car> cars) {this.cars = cars;}
    public void setBackCar(List<BackCar> backcars) {this.backcars = backcars;}
    public void setLogs(List<Log> logs) {this.logs = logs;}
    public void setLilyPads(List<LilyPad> lilyPads) {this.lilyPads = lilyPads;}
    public void setLines(List<List<Object>> lines) {this.lines = lines;}
    public void setRoads(List<Road> roads) {this.roads = roads;}
    public void setRivers(List<River> rivers) {this.rivers = rivers;}
    public void setDirts(List<Dirt> dirts) {this.dirts = dirts;}

    public boolean isCar(Position position) {
        for (Car car : cars)
            if (car.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isBackCar(Position position) {
        for (BackCar Backcar : backcars)
            if (Backcar.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isLog(Position position) {
        for (Log log : logs)
            if (log.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isLilyPad(Position position) {
        for (LilyPad lilyPad : lilyPads)
            if (lilyPad.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isRiver(Position position) {
        for (River river : rivers)
            if(river.getPosition().equals(position)) return true;
        return false;
    }
}
