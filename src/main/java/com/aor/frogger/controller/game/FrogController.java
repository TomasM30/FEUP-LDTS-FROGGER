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
        /*
        if (getModel().isLeaf(getModel().getFrog().getPosition())) {
            if (time - lastMovement > 500) {
                moveFrogLeft();
                this.lastMovement = time;
            }
        }
        if (getModel().isLog(getModel().getFrog().getPosition())){
            if (time - lastMovement > 500) {
                moveFrogRight();
                this.lastMovement = time;
            }
        }
        */
    }

    private void moveFrogLeft() {moveFrog(getModel().getFrog().getPosition().getLeft());}

    private void moveFrogDown() {if(getModel().getFrog().getPosition().getY1()<6)moveFrog(getModel().getFrog().getPosition().getDown());}

    private void moveFrogRight() {moveFrog(getModel().getFrog().getPosition().getRight());}

    private void moveFrogUp() {if(getModel().getFrog().getPosition().getY1()>0)moveFrog(getModel().getFrog().getPosition().getUp());}


    private void moveFrog(Position position) {
        getModel().getFrog().setPosition(position);
        if (getModel().isCar(position))
            getModel().getFrog().setPosition(new Position(getModel().getWidth() / 2 - 1, 6));
        if(position.getX1() ==-1){
            getModel().getFrog().setPosition(new Position(getModel().getLines().get(0).size()-1,position.getY1()));
        }
        if (position.getX1() == getModel().getLines().get(0).size()){
            getModel().getFrog().setPosition(new Position(0,position.getY1()));
        }
        if(getModel().isCar(position) || getModel().isBackCar(position)) {
            getModel().getFrog().setPosition(new Position(getModel().getWidth()/2-1,6 ));
            getModel().getFrog().decreaseLives();
        }
        if (getModel().isRiver(position) && !(getModel().isLog(position)) && !(getModel().isLilyPad(position))) {
            getModel().getFrog().setPosition(new Position(getModel().getWidth() / 2 - 1, 6));
            getModel().getFrog().decreaseLives();
        }
    }
}
