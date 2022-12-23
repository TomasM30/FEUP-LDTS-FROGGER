package com.aor.frogger.viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.game.GameWon;
import com.aor.frogger.model.game.River;

public class GameWonViewer extends Viewer<GameWon>{
    public GameWonViewer(GameWon model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new River.Position(5,1), "You won!", "#FFD700");
        for(int j = 0; j<getModel().getNumberOptions();j++) {
            gui.drawText(new River.Position(5,4+j),getModel().getOption(j),getModel().isSelected(j) ? "#FFD700" : "#FFFFFF");
        }
    }
}
