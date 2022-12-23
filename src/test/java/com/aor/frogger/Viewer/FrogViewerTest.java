package com.aor.frogger.Viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.game.Frog;
import com.aor.frogger.viewer.FrogViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FrogViewerTest {
    private Frog frog;
    private FrogViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        frog = new Frog(10, 10,3);
        viewer = new FrogViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawFrog() {
        viewer.draw(frog, gui);
        Mockito.verify(gui, Mockito.times(1)).drawFrog(frog.getPosition());
    }
}
