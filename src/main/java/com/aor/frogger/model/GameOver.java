package com.aor.frogger.model;

import java.util.Arrays;
import java.util.List;

public class GameOver {
    private final List<String> phrase;
    private int currentEntry = 0;

    public GameOver() {this.phrase = Arrays.asList("You Lost!");}
    public List<String> getPhrase() {
        return phrase;
    }
}
