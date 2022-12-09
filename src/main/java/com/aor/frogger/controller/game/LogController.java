package com.aor.frogger.controller.game;

import com.aor.frogger.Game;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.Log;
import com.aor.frogger.model.Position;
import com.aor.frogger.model.arena.Arena;

import java.io.IOException;

public class LogController extends GameController{
    private long lastMovement;
    public LogController(Arena arena) {super(arena); this.lastMovement=0;}

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {

            for (Log log : getModel().getLogs())
                moveLog(log, log.getPosition().getRight());
            this.lastMovement = time;
        }
    }
    private void moveLog(Log log, Position position) {
        log.setPosition(position);
        if(position.getX1() == getModel().getLines().get(0).size())
            log.setPosition(new Position(0,position.getY1()));
    }
}
