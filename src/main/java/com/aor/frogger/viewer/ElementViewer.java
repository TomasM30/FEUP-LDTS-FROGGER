package com.aor.frogger.viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.game.Element;


public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}

