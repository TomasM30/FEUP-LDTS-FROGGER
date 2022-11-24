package com.aor.frogger.model.arena;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setLines(createLines());

        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<List<Object>> getLines();

    protected abstract List<List<Object>> createLines();
}