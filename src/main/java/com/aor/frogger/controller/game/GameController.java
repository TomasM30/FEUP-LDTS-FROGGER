package com.aor.frogger.controller.game;

import com.aor.frogger.controller.Controller;
import com.aor.frogger.model.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
