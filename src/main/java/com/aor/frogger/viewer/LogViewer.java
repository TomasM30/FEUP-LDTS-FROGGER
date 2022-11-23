package com.aor.frogger.viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.Log;

public class LogViewer implements RectangleViewer<Log>{
    @Override
    public void draw(Log log, GUI gui) {gui.drawLog(log.getPosition());}
}

