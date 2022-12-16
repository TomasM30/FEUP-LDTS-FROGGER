package com.aor.frogger.controller.game;

import com.aor.frogger.Game;
import com.aor.frogger.controller.Controller;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.GameOver;
import com.aor.frogger.model.Menu;
import com.aor.frogger.states.MenuState;

import java.io.IOException;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver gameOver) {
        super(gameOver);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case SELECT:
                game.setState(new MenuState(new Menu()));
        }
    }
}
