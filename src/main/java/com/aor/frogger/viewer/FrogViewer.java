package com.aor.frogger.viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.game.Frog;

public class FrogViewer implements ElementViewer<Frog>{
    @Override
    public void draw(Frog frog, GUI gui) {gui.drawFrog(frog.getPosition());}
}
