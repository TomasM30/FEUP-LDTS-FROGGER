package com.aor.frogger.Viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.arena.Arena;
import com.aor.frogger.model.game.*;
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

        arena.setFrog(new Frog(5,10,3));
        arena.setCars(Arrays.asList(new Car(4,9), new Car(7,8), new Car(2,7)));
        arena.setLogs(Arrays.asList(new Log(2,1), new Log(6,2), new Log(4,2)));
        arena.setDirts(Arrays.asList(new Dirt(2,0), new Dirt(6,5), new Dirt(4,10)));
        arena.setBackCar(Arrays.asList(new BackCar(5,9), new BackCar(8,8), new BackCar(3,7)));
        arena.setRoads(Arrays.asList(new Road(2,9),new Road(1,8), new Road(9,7)));
        arena.setRivers(Arrays.asList(new River(6,4), new River(5,2), new River(1,1)));
        arena.setLilyPads(Arrays.asList(new LilyPad(7,4), new LilyPad(1,4), new LilyPad(2,3)));
    }
    @Test
    void drawDirts() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawDirt(new River.Position(2, 0));
        Mockito.verify(gui, Mockito.times(1)).drawDirt(new River.Position(6, 5));
        Mockito.verify(gui, Mockito.times(1)).drawDirt(new River.Position(4, 10));
        Mockito.verify(gui, Mockito.times(3)).drawDirt(Mockito.any(River.Position.class));
    }
    @Test
    void drawBackCar() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawBackCar(new River.Position(5, 9));
        Mockito.verify(gui, Mockito.times(1)).drawBackCar(new River.Position(8, 8));
        Mockito.verify(gui, Mockito.times(1)).drawBackCar(new River.Position(3, 7));
        Mockito.verify(gui, Mockito.times(3)).drawBackCar(Mockito.any(River.Position.class));
    }
    @Test
    void drawRoads() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawRoad(new River.Position(2, 9));
        Mockito.verify(gui, Mockito.times(1)).drawRoad(new River.Position(1, 8));
        Mockito.verify(gui, Mockito.times(1)).drawRoad(new River.Position(9, 7));
        Mockito.verify(gui, Mockito.times(3)).drawRoad(Mockito.any(River.Position.class));
    }
    @Test
    void drawRivers() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawRiver(new River.Position(6, 4));
        Mockito.verify(gui, Mockito.times(1)).drawRiver(new River.Position(5, 2));
        Mockito.verify(gui, Mockito.times(1)).drawRiver(new River.Position(1, 1));
        Mockito.verify(gui, Mockito.times(3)).drawRiver(Mockito.any(River.Position.class));
    }
    @Test
    void drawLilyPads() throws IOException{
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawLilyPad(new River.Position(7, 4));
        Mockito.verify(gui, Mockito.times(1)).drawLilyPad(new River.Position(1, 4));
        Mockito.verify(gui, Mockito.times(1)).drawLilyPad(new River.Position(2, 3));
        Mockito.verify(gui, Mockito.times(3)).drawLilyPad(Mockito.any(River.Position.class));
    }
    @Test
    void drawLogs() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawLog(new River.Position(2, 1));
        Mockito.verify(gui, Mockito.times(1)).drawLog(new River.Position(6, 2));
        Mockito.verify(gui, Mockito.times(1)).drawLog(new River.Position(4, 2));
        Mockito.verify(gui, Mockito.times(3)).drawLog(Mockito.any(River.Position.class));
    }

    @Test
    void drawCars() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawCar(new River.Position(4, 9));
        Mockito.verify(gui, Mockito.times(1)).drawCar(new River.Position(7, 8));
        Mockito.verify(gui, Mockito.times(1)).drawCar(new River.Position(2, 7));
        Mockito.verify(gui, Mockito.times(3)).drawCar(Mockito.any(River.Position.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
