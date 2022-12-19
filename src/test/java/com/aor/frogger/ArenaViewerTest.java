package com.aor.frogger;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.*;
import com.aor.frogger.model.arena.Arena;
import com.aor.frogger.viewer.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

class ArenaViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);

        arena.setLogs(Arrays.asList(new Log(1, 5), new Log(2, 5), new Log(3, 5)));
        arena.setCars(Arrays.asList(new Car(4, 1), new Car(5, 2)));
        arena.setLilyPads(Arrays.asList(new LilyPad(2,4),new LilyPad(1,4),new LilyPad(5,4)));
        arena.setFrog(new Frog(5, 8,3));
    }


    @Test
    void drawLogs() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawLog(new Position(1, 5));
        Mockito.verify(gui, Mockito.times(1)).drawLog(new Position(2, 5));
        Mockito.verify(gui, Mockito.times(1)).drawLog(new Position(3, 5));
        Mockito.verify(gui, Mockito.times(3)).drawLog(Mockito.any(Position.class));
    }

    @Test
    void drawCars() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawCar(new Position(4, 1));
        Mockito.verify(gui, Mockito.times(1)).drawCar(new Position(5, 2));
        Mockito.verify(gui, Mockito.times(2)).drawCar(Mockito.any(Position.class));
    }

    @Test
    void drawFrog() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawFrog(new Position(5, 8));
        Mockito.verify(gui, Mockito.times(1)).drawFrog(Mockito.any(Position.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
