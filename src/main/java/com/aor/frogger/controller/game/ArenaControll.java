package com.aor.frogger.controller.game;

import com.aor.frogger.Game;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.GameOver;
import com.aor.frogger.model.Menu;
import com.aor.frogger.model.arena.Arena;
import com.aor.frogger.states.GameOverState;
import com.aor.frogger.states.MenuState;

import java.io.IOException;

public class ArenaControll extends GameController {
    private final FrogController frogController;
    private final CarController carController;
    private final BackCarController backcarController;
    private final LogController logController;
    private final LeafController leafController;
    private final RiverController riverController;
    private final RoadController roadController;


    public ArenaControll(Arena arena) {
        super(arena);

        this.frogController = new FrogController(arena);
        this.carController = new CarController(arena);
        this.backcarController = new BackCarController(arena);
        this.logController = new LogController(arena);
        this.leafController = new LeafController(arena);
        this.riverController = new RiverController(arena);
        this.roadController = new RoadController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT){
            game.setState(new MenuState(new Menu()));
        }
        if(getModel().getFrog().getLives() == 0){
            game.setState(new GameOverState(new GameOver()));
        }
        else {
            frogController.step(game, action, time);
            carController.step(game, action, time);
            backcarController.step(game,action,time);
            logController.step(game,action,time);
            leafController.step(game,action,time);
            //riverController.step(game,action,time);
            //roadController.step(game,action,time);
        }
    }
}
