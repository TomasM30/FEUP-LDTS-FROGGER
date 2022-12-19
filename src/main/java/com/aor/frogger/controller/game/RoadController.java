
/*
package com.aor.frogger.controller.game;

import com.aor.frogger.Game;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.Position;
import com.aor.frogger.model.arena.Arena;
import com.aor.frogger.model.game.Road;

import java.io.IOException;

public class RoadController extends GameController{
    private long lastMovement;

    public RoadController(Arena arena) {super(arena);this.lastMovement=0;}

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {

            for (Road road : getModel().getRoads()) {
                moveRoad(road, road.getPosition().getLeft());
            }
            this.lastMovement = time;
        }
    }
    private void moveRoad(Road road, Position position) {
        road.setPosition(position);
        if(position.getX1() == -1)
            road.setPosition(new Position(getModel().getLines().get(0).size(),position.getY1()));
    }
}
*/