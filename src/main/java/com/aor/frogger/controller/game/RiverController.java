package com.aor.frogger.controller.game;

import com.aor.frogger.Game;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.Position;
import com.aor.frogger.model.arena.Arena;
import com.aor.frogger.model.game.River;

import java.io.IOException;

public class RiverController extends GameController{
    private long lastMovement;

    public RiverController(Arena arena) {super(arena);this.lastMovement=0;}

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {

            for (River river : getModel().getRivers()) {
                if (river.getPosition().getY1() == 2) {
                    moveRiver(river, river.getPosition().getLeft());
                }
                if (river.getPosition().getY1() == 1) {
                    moveRiver(river, river.getPosition().getRight());
                }
            }
            this.lastMovement = time;
        }
    }
    private void moveRiver(River river, Position position) {
        river.setPosition(position);
        if(position.getX1() == -1 && position.getY1()==2)
            river.setPosition(new Position(getModel().getLines().get(0).size(),position.getY1()));
        /*
        if(position.getX1() == 0 && position.getY1()==2)
            river.setPosition(new Position(-1,position.getY1()));
        if(position.getX1()==-1 && position.getY1()==2)
            river.setPosition(new Position(getModel().getLines().get(0).size(), position.getY1()));
        */
        if(position.getX1() == getModel().getLines().get(0).size() && position.getY1()==1)
            river.setPosition(new Position(0,position.getY1()));
    }
}
