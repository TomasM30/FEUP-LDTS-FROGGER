package com.aor.frogger.controller.game;

import com.aor.frogger.Game;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.arena.Arena;
import com.aor.frogger.model.game.River;

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

    public void moveFrogLeft() {moveFrog(getModel().getFrog().getPosition().getLeft());}

    public void moveFrogDown() {if(getModel().getFrog().getPosition().getY1()< getModel().getHeight()-1)moveFrog(getModel().getFrog().getPosition().getDown());}

    public void moveFrogRight() {moveFrog(getModel().getFrog().getPosition().getRight());}

    public void moveFrogUp() {if(getModel().getFrog().getPosition().getY1()>0)moveFrog(getModel().getFrog().getPosition().getUp());}


    private void moveFrog(River.Position position) {
        getModel().getFrog().setPosition(position);
        if (getModel().isCar(position))
            getModel().getFrog().setPosition(new River.Position(getModel().getWidth() / 2 , getModel().getHeight()-1));
        if(position.getX1() ==-1){
            getModel().getFrog().setPosition(new River.Position(getModel().getWidth()-1,position.getY1()));
        }
        if (position.getX1() == getModel().getWidth()){
            getModel().getFrog().setPosition(new River.Position(0,position.getY1()));
        }
        if(getModel().isCar(position) || getModel().isBackCar(position)) {
            getModel().getFrog().setPosition(new River.Position(getModel().getWidth()/2,getModel().getHeight()-1 ));
            getModel().getFrog().decreaseLives();
        }
        if (getModel().isRiver(position) && !(getModel().isLog(position)) && !(getModel().isLilyPad(position))) {
            getModel().getFrog().setPosition(new River.Position(getModel().getWidth() / 2, getModel().getHeight()-1));
            getModel().getFrog().decreaseLives();
        }
    }
}
