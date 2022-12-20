package com.aor.frogger.controller.game;

import com.aor.frogger.Game;
import com.aor.frogger.controller.Controller;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.game.GameOver;
import com.aor.frogger.model.arena.LoaderArenaBuilder;
import com.aor.frogger.states.GameState;

import java.io.IOException;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver gameOver) {
        super(gameOver);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousPhrase();
                break;
            case DOWN:
                getModel().nextPhrase();
                break;
            case SELECT:
                if(getModel().isSelectedExit()) game.setState(null);
                if(getModel().isSelectedPlayAgain()) game.setState(new GameState(new LoaderArenaBuilder("Start Game").createArena()));
        }
    }
}
