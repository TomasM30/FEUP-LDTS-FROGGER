package com.aor.frogger.Model;

import com.aor.frogger.Game;
import com.aor.frogger.controller.game.MenuController;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.arena.LoaderArenaBuilder;
import com.aor.frogger.model.game.Menu;
import com.aor.frogger.states.GameState;
import com.aor.frogger.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MenuTest {
    private Menu menu;
    private MenuController controller;
    private Game game;
    private MenuState state;

    @BeforeEach
    void setup() throws IOException, URISyntaxException, FontFormatException {
        game = Mockito.mock(Game.class);
        menu = new Menu();
        controller = new MenuController(menu);
        state = new MenuState(menu);
    }
    @Test
    void MenuTest() throws IOException {
        long time = 0;
        game.setState(state);
        while(time < 1000) {
            time += 500;
            controller.step(game, GUI.ACTION.DOWN,time);
        }
        time += 500;
        controller.step(game,GUI.ACTION.SELECT,time);
        Mockito.verify(game,Mockito.times(1)).setState(new GameState(new LoaderArenaBuilder("Start Game").createArena()));
    }

}
