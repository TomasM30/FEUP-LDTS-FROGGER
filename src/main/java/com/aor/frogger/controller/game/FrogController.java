package com.aor.frogger.controller.game;

import com.aor.frogger.Game;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.Position;
import com.aor.frogger.model.arena.Arena;

public class FrogController extends GameController {
    public FrogController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) moveFrogUp();
        if (action == GUI.ACTION.RIGHT) moveFrogRight();
        if (action == GUI.ACTION.DOWN) moveFrogDown();
        if (action == GUI.ACTION.LEFT) moveFrogLeft();
    }

    private void moveFrogLeft() {moveFrog(getModel().getFrog().getPosition().getLeft());}

    private void moveFrogDown() {moveFrog(getModel().getFrog().getPosition().getDown());}

    private void moveFrogRight() {moveFrog(getModel().getFrog().getPosition().getRight());}

    private void moveFrogUp() {moveFrog(getModel().getFrog().getPosition().getUp());}

    public void moveFrog(Position position) {
        if(getModel().isCar(position)) {
            getModel().getFrog().setPosition(new Position(getModel().getWidth()/2,0 ));
        }
        else if((getModel().isLeaf(position))) {
            getModel().getFrog().setPosition(position);
        }
        else if((getModel().isLog(position))) {
            getModel().getFrog().setPosition(position);
        }
        else if(getModel().isRiver(position)) {
            getModel().getFrog().setPosition(new Position(getModel().getWidth()/2,0 ));
        }
        else if(getModel().isRoad(position)) {
            getModel().getFrog().setPosition(position);
        }
    }
}
