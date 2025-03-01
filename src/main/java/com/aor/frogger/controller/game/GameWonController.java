package com.aor.frogger.controller.game;

import com.aor.frogger.Game;
import com.aor.frogger.controller.Controller;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.game.GameWon;
import com.aor.frogger.model.arena.LoaderArenaBuilder;
import com.aor.frogger.states.GameState;

import java.io.IOException;

public class GameWonController extends Controller<GameWon> {
    public GameWonController(GameWon gameWon) { super(gameWon); }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousOption();
                break;
            case DOWN:
                getModel().nextOption();
                break;
            case SELECT:
                if(getModel().isSelectedExit()) game.setState(null);
                if(getModel().isSelectedPlayAgain()) game.setState(new GameState(new LoaderArenaBuilder("Start Game").createArena()));
            default:
                break;
        }
    }
}
