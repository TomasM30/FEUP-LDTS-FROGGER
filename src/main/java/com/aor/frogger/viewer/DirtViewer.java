package com.aor.frogger.viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.game.Dirt;

public class DirtViewer implements ElementViewer<Dirt>{
    @Override
    public void draw(Dirt dirt, GUI gui) {
        gui.drawDirt(dirt.getPosition());
    }
}
