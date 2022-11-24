package com.aor.frogger.viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.game.Road;

public class RoadViewer implements ElementViewer<Road>{
    @Override
    public void draw(Road road, GUI gui) {
        gui.drawRoad(road.getPosition());
    }
}