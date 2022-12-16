package com.aor.frogger.states;

import com.aor.frogger.controller.Controller;
import com.aor.frogger.controller.game.GameWonController;
import com.aor.frogger.model.GameWon;
import com.aor.frogger.viewer.GameWonViewer;
import com.aor.frogger.viewer.Viewer;

public class GameWonState extends State<GameWon>{

    public GameWonState(GameWon model) {super(model);}

    @Override
    protected Viewer<GameWon> getViewer() {return new GameWonViewer(getModel());}
    @Override
    protected Controller<GameWon> getController() {return new GameWonController(getModel());}
}
