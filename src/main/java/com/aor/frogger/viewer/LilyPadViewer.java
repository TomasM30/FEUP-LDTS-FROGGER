package com.aor.frogger.viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.LilyPad;

public class LilyPadViewer implements ElementViewer<LilyPad>{
    @Override
    public void draw(LilyPad lilyPad, GUI gui) {gui.drawLilyPad(lilyPad.getPosition());}
}

