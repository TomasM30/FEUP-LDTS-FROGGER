package com.aor.frogger.states;

import com.aor.frogger.controller.Controller;
import com.aor.frogger.controller.game.GameOverController;
import com.aor.frogger.model.GameOver;
import com.aor.frogger.viewer.GameOverViewer;
import com.aor.frogger.viewer.Viewer;

public class GameOverState extends State<GameOver>{

    public GameOverState(GameOver model) {
        super(model);
    }

    @Override
    protected Viewer<GameOver> getViewer() {
        return new GameOverViewer(getModel());
    }

    @Override
    protected Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }
}
