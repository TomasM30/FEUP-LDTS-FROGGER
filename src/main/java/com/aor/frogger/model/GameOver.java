package com.aor.frogger.model;

import java.util.Arrays;
import java.util.List;

public class GameOver {
    private final List<String> phrases;
    private int currentPhrase = 0;

    public GameOver() {this.phrases = Arrays.asList("Play again", "Exit");}
    public List<String> getPhrases() {
        return phrases;
    }
    public void nextPhrase() {
        currentPhrase++;
        if (currentPhrase > this.phrases.size() - 1)
            currentPhrase = 0;
    }
    public void previousPhrase() {
        currentPhrase--;
        if (currentPhrase < 0)
            currentPhrase = this.phrases.size() - 1;
    }
    public String getPhrase(int i) {return phrases.get(i);}
    public boolean isSelected(int i) {return currentPhrase==i;}
    public boolean isSelectedExit() {return isSelected(1);}
    public boolean isSelectedPlayAgain() {return isSelected(0);}
    public int getNumberPhrases() {return phrases.size();}

}
