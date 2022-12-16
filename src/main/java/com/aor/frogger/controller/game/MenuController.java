package com.aor.frogger.controller.game;

import com.aor.frogger.Game;
import com.aor.frogger.controller.Controller;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.Menu;
import com.aor.frogger.model.arena.LoaderArenaBuilder;
import com.aor.frogger.states.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStartGame()) game.setState(new GameState(new LoaderArenaBuilder("Start Game").createArena()));
        }
    }
}
