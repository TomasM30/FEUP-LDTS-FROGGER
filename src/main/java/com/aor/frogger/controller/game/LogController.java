package com.aor.frogger.controller.game;

import com.aor.frogger.Game;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.game.Log;
import com.aor.frogger.model.arena.Arena;
import com.aor.frogger.model.game.River;

import java.io.IOException;

public class LogController extends GameController{
    private long lastMovement;
    public LogController(Arena arena) {super(arena); this.lastMovement=0;}

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 300) {

            for (Log log : getModel().getLogs())
                moveLog(log, log.getPosition().getRight());
            this.lastMovement = time;
        }
    }
    public void moveLog(Log log, River.Position position) {
        if(log.getPosition().equals(getModel().getFrog().getPosition())) {
            getModel().getFrog().setPosition(position);
            if (position.getX1() == getModel().getWidth()) {
                getModel().getFrog().setPosition(new River.Position(0, position.getY1()));
            }
        }
        log.setPosition(position);
        if(position.getX1() == getModel().getWidth())
            log.setPosition(new River.Position(0,position.getY1()));
    }
}
