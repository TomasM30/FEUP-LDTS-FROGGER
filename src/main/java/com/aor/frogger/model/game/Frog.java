package com.aor.frogger.model.game;

import com.aor.frogger.model.game.Element;

public class Frog extends Element {
    private int lives;
    public Frog(int x1, int y1, int lives) {
        super(x1, y1);
        this.lives = lives;
    }

    public int getLives() {
        return this.lives;
    }
    public void decreaseLives() {
        this.lives -= 1;
    }
}
