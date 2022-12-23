/*
package com.aor.frogger.Viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.game.Menu;
import com.aor.frogger.viewer.MenuViewer;
import com.aor.frogger.viewer.Viewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuViewerTest {
    private Viewer viewer;
    private GUI gui;
    private MenuViewer menuViewer;
    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu();
        viewer = Mockito.mock(Viewer.class);
        menuViewer = new MenuViewer(menu);
    }

    @Test
    void Menu() throws IOException {
        menuViewer.draw(gui);
        Mockito.verify(viewer, Mockito.times(1)).drawElements(gui);
    }
}
*/