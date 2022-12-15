package com.aor.frogger.controller.game;

import com.aor.frogger.Game;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.Position;
import com.aor.frogger.model.arena.Arena;

public class FrogController extends GameController {
    private long lastMovement;
    public FrogController(Arena arena) {
        super(arena);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) moveFrogUp();
        if (action == GUI.ACTION.RIGHT) moveFrogRight();
        if (action == GUI.ACTION.DOWN) moveFrogDown();
        if (action == GUI.ACTION.LEFT) moveFrogLeft();
        if(action == GUI.ACTION.NONE) moveFrogAuto();
    }

    private void moveFrogLeft() {moveFrog(getModel().getFrog().getPosition().getLeft());}

    private void moveFrogDown() {moveFrog(getModel().getFrog().getPosition().getDown());}

    private void moveFrogRight() {moveFrog(getModel().getFrog().getPosition().getRight());}

    private void moveFrogUp() {moveFrog(getModel().getFrog().getPosition().getUp());}

    private void moveFrogAuto() {moveFrog(getModel().getFrog().getPosition());}

    private void moveFrog(Position position) {
        getModel().getFrog().setPosition(position);
        if(position.getX1() <0){
            getModel().getFrog().setPosition(new Position(19, position.getY1()));
        }
        if (position.getX1() > 19){
            getModel().getFrog().setPosition(new Position(0, position.getY1()));
        }
        if(position.getY1() > 6){
            getModel().getFrog().setPosition(new Position(position.getX1(), 6));
        }
        if(getModel().isCar(position) || getModel().isBackCar(position)) {
            getModel().getFrog().setPosition(new Position(getModel().getWidth()/2-1,6 ));
            getModel().getFrog().decreaseLives();
        }
        if(getModel().isRiver(position) && !(getModel().isLeaf(position)) && !(getModel().isLog(position))) {
            getModel().getFrog().setPosition(new Position(getModel().getWidth()/2-1,6 ));
            getModel().getFrog().decreaseLives();
        }
        if(getModel().isDirt(position)) {
            return;
        }
        if(getModel().isLeaf(position)) {
            getModel().getFrog().getPosition().getLeft();
        }
        if(getModel().isLog(position)) {
            getModel().getFrog().getPosition().getRight();
        }
    }
}
