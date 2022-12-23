package com.aor.frogger.states;

import com.aor.frogger.controller.Controller;
import com.aor.frogger.controller.game.ArenaController;
import com.aor.frogger.model.arena.Arena;
import com.aor.frogger.viewer.GameViewer;
import com.aor.frogger.viewer.Viewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}

