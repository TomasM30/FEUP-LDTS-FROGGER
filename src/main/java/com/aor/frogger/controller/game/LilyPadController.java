package com.aor.frogger.controller.game;

import com.aor.frogger.Game;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.LilyPad;
import com.aor.frogger.model.Position;
import com.aor.frogger.model.arena.Arena;

import java.io.IOException;

public class LilyPadController extends GameController{
    private long lastMovement;
    public LilyPadController(Arena arena) {super(arena); this.lastMovement=0;}

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 300) {

            for (LilyPad lilyPad : getModel().getLilyPads())
                moveLilyPad(lilyPad, lilyPad.getPosition().getLeft());
            this.lastMovement = time;
        }
    }
    private void moveLilyPad(LilyPad lilyPad, Position position) {
        if (lilyPad.getPosition().equals(getModel().getFrog().getPosition())){
            getModel().getFrog().setPosition(position);
            if (position.getX1() == -1) {
                getModel().getFrog().setPosition(new Position(getModel().getLines().get(0).size()-1, position.getY1()));
            }
        }
        lilyPad.setPosition(position);
        if(position.getX1() == -1)
            lilyPad.setPosition(new Position(getModel().getLines().get(0).size()-1,position.getY1()));
    }
}
