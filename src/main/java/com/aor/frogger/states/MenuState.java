package com.aor.frogger.states;

import com.aor.frogger.controller.Controller;
import com.aor.frogger.controller.game.MenuController;
import com.aor.frogger.model.Menu;
import com.aor.frogger.viewer.MenuViewer;
import com.aor.frogger.viewer.Viewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
