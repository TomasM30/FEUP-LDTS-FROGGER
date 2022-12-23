package com.aor.frogger.viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.game.BackCar;

public class BackCarViewer implements ElementViewer<BackCar>{
    @Override
    public void draw(BackCar backcar, GUI gui) {
        gui.drawBackCar(backcar.getPosition());
    }
}
