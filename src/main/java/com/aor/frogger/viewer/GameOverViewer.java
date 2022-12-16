package com.aor.frogger.viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.GameOver;
import com.aor.frogger.model.Position;

public class GameOverViewer extends Viewer<GameOver>{
    public GameOverViewer(GameOver gameOver) {
        super(gameOver);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(5, 7), getModel().getPhrase().get(0), "#FFD700");
    }
}
