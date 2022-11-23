package com.aor.frogger.model;

public class Frog extends Rectangle {
    private int lives;
    public Frog(int x1, int x2, int y1, int y2, int lives) {
        super(x1, x2, y1, y2);
        this.lives = lives;
    }

    public int getLives() {
        return this.lives;
    }
    public int decreaseLives() {
        return this.lives--;
    }
}
