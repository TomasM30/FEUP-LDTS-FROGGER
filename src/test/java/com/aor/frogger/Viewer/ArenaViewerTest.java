package com.aor.frogger.Viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.Position;
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
        Mockito.verify(gui, Mockito.times(3)).drawDirt(Mockito.any(Position.class));
    }
    @Test
    void drawBackCar() throws IOException{
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(3)).drawBackCar(Mockito.any(Position.class));
    }
    @Test
    void drawRoads() throws IOException{
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(3)).drawRoad(Mockito.any(Position.class));
    }
    @Test
    void drawRivers() throws IOException{
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(3)).drawRiver(Mockito.any(Position.class));
    }
    @Test
    void drawLilyPads() throws IOException{
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(3)).drawLilyPad(Mockito.any(Position.class));
    }
    @Test
    void drawLogs() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(3)).drawLog(Mockito.any(Position.class));
    }

    @Test
    void drawCars() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(3)).drawCar(Mockito.any(Position.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
