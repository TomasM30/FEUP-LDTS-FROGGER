package com.aor.frogger.controller.game;

import com.aor.frogger.Game;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.GameOver;
import com.aor.frogger.model.GameWon;
import com.aor.frogger.model.Menu;
import com.aor.frogger.model.arena.Arena;
import com.aor.frogger.states.GameOverState;
import com.aor.frogger.states.GameWonState;
import com.aor.frogger.states.MenuState;

import java.io.IOException;

public class ArenaControll extends GameController {
    private final FrogController frogController;
    private final CarController carController;
    private final BackCarController backcarController;
    private final LogController logController;
    private final LilyPadController leafController;


    public ArenaControll(Arena arena) {
        super(arena);

        this.frogController = new FrogController(arena);
        this.carController = new CarController(arena);
        this.backcarController = new BackCarController(arena);
        this.logController = new LogController(arena);
        this.leafController = new LilyPadController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT){
            game.setState(new MenuState(new Menu()));
        }
        if(getModel().getFrog().getLives() == 0){
            game.setState(new GameOverState(new GameOver()));
        }
        if(getModel().getFrog().getPosition().getY1() == 0) {
            game.setState(new GameWonState(new GameWon()));
        }
        else {
            frogController.step(game, action, time);
            carController.step(game, action, time);
            backcarController.step(game,action,time);
            logController.step(game,action,time);
            leafController.step(game,action,time);
        }
    }
}
