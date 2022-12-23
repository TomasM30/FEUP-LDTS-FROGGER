package com.aor.frogger.controller.game;

import com.aor.frogger.Game;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.Position;
import com.aor.frogger.model.arena.Arena;
import com.aor.frogger.model.game.BackCar;

import java.io.IOException;

public class BackCarController extends GameController{
    private long lastMovement;
    public BackCarController(Arena arena) {super(arena); this.lastMovement=0;}

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 250) {

            for (BackCar backcar : getModel().getBackCar())
                moveBackCar(backcar, backcar.getPosition().getLeft());
            this.lastMovement = time;
        }
    }
    private void moveBackCar(BackCar backcar, Position position) {
        backcar.setPosition(position);
        if(position.getX1() == 0)
            backcar.setPosition(new Position(getModel().getWidth()-1,position.getY1()));
        if (getModel().getFrog().getPosition().equals(position)) {
            getModel().getFrog().setPosition(new Position(getModel().getWidth() / 2 - 1, 6));
            getModel().getFrog().decreaseLives();
        }
    }
}
