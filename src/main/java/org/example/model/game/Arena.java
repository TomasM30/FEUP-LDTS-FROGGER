package org.example.model.game;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private Frog frog;
    private List<Car> cars;
    private List<Log> logs;
    private List<Leave> leaves;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public int getWidth() {return this.width;}
    public int getHeight() {return this.height;}
    public Frog getFrog() {return this.frog;}
    public List<Car> getCars() {return this.cars;}
    public List<Log> getLogs() {return this.logs;}
    public List<Leave> getLeaves() {return this.leaves;}

    public void setFrog(Frog a) {this.frog = a;}
    public void setCars(List<Car> cars) {this.cars = cars;}
    public void setLogs(List<Log> logs) {this.logs = logs;}
    public void setLeaves(List<Leave> leaves) {this.leaves = leaves;}

}
