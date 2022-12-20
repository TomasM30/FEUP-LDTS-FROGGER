package com.aor.frogger.viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.game.Log;

public class LogViewer implements ElementViewer<Log>{
    @Override
    public void draw(Log log, GUI gui) {gui.drawLog(log.getPosition());}
}

