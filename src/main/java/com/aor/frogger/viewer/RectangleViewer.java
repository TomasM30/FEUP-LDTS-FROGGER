package com.aor.frogger.viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.Rectangle;

public interface RectangleViewer<T extends Rectangle> {
    void draw(T element, GUI gui);
}

