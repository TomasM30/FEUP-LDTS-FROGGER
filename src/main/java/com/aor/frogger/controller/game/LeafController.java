package com.aor.frogger.controller.game;

import com.aor.frogger.Game;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.arena.Arena;

import java.io.IOException;

public class LeafController extends GameController{
    public LeafController(Arena arena) {super(arena);}

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

    }
}
