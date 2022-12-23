package com.aor.frogger.model.game;

import java.util.Arrays;
import java.util.List;

public class GameWon {
    private final List<String> options;
    private int currentOption = 0;

    public GameWon() {this.options = Arrays.asList("Play again", "Exit");}
    public List<String> getOptions() {
        return options;
    }
    public void nextOption() {
        currentOption++;
        if(currentOption > this.options.size()-1)
            currentOption = 0;
    }
    public void previousOption() {
        currentOption--;
        if(currentOption < 0)
            currentOption = this.options.size()-1;
    }
    public String getOption(int i) {return options.get(i);}
    public boolean isSelected(int i) {return currentOption==i;}
    public boolean isSelectedExit() {return isSelected(1);}
    public boolean isSelectedPlayAgain() {return isSelected(0);}
    public int getNumberOptions() {return options.size();}
}
