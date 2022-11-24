package com.aor.frogger.viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.game.River;

public class RiverViewer implements ElementViewer<River>{
    @Override
    public void draw(River river, GUI gui) {
        gui.drawRiver(river.getPosition());
    }
}
