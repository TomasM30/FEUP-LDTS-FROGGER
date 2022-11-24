package com.aor.frogger.model;

public class Frog extends Element {
    private int lives;
    public Frog(int x1, int y1, int lives) {
        super(x1, y1);
        this.lives = lives;
    }

    public int getLives() {
        return this.lives;
    }
    public int decreaseLives() {
        return this.lives--;
    }
}
