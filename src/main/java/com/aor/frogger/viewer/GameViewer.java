package com.aor.frogger.viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.Element;
import com.aor.frogger.model.Position;
import com.aor.frogger.model.arena.Arena;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui,getModel().getRivers(), new RiverViewer());
        drawElements(gui,getModel().getDirts(), new DirtViewer());
        drawElements(gui,getModel().getRoads(), new RoadViewer());
        drawElements(gui, getModel().getLogs(), new LogViewer());
        drawElements(gui, getModel().getCars(), new CarViewer());
        drawElements(gui,getModel().getBackCar(), new BackCarViewer());
        drawElement(gui, getModel().getFrog(), new FrogViewer());
        drawElements(gui, getModel().getLeaves(), new LeafViewer());

        gui.drawText(new Position(0, 0), "Lives: " + getModel().getFrog().getLives(), "#FFD700");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
