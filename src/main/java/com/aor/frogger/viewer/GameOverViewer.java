package com.aor.frogger.viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.game.GameOver;
import com.aor.frogger.model.Position;

public class GameOverViewer extends Viewer<GameOver>{
    public GameOverViewer(GameOver gameOver) {
        super(gameOver);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 1), "You lost!", "#FFD700");
        for(int i = 0; i<getModel().getNumberPhrases();i++) {
            gui.drawText(new Position(5, 4 + i), getModel().getPhrase(i),getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
