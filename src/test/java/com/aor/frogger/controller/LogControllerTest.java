package com.aor.frogger.controller;

import com.aor.frogger.Game;
import com.aor.frogger.controller.game.LogController;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.Position;
import com.aor.frogger.model.arena.Arena;
import com.aor.frogger.model.game.Frog;
import com.aor.frogger.model.game.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LogControllerTest {
    private LogController controller;
    private Frog frog;
    private Arena arena;
    private Game game;
    private LogController controller2;

    @BeforeEach
    void setup() {
        arena = new Arena(11,11);
        frog = new Frog(5,3,10);

        arena.setFrog(frog);
        arena.setCars(Arrays.asList());
        arena.setLogs(Arrays.asList());
        arena.setDirts(Arrays.asList());
        arena.setBackCar(Arrays.asList());
        arena.setRoads(Arrays.asList());
        arena.setRivers(Arrays.asList());
        arena.setLilyPads(Arrays.asList());
        arena.setLines(Arrays.asList());
        controller = new LogController(arena);
        game = Mockito.mock(Game.class);
        controller2 = Mockito.mock(LogController.class);
    }

    @Test
    void moveLog() throws IOException {
        Log log = new Log(8,2);
        arena.setLogs(Arrays.asList(log));
        long time = 0;
        while(time <= 2000) {
            time += 500;
            controller.step(game, GUI.ACTION.NONE, time);
        }
        assertNotEquals(new Position(6,2), log.getPosition());
    }
    @Test
    void moveLogFrog() throws IOException {
        Log log = new Log(4, 3);
        arena.setLogs(Arrays.asList(log));

        long time = 0;
        while(time <= 2000) {
            time += 500;
            controller.step(game, GUI.ACTION.NONE, time);
        }
        assertNotEquals(new Position(6, 3), log.getPosition());
        assertEquals(frog.getPosition(),log.getPosition());
        assertEquals(frog.getLives(),10);
        Mockito.verify(controller2,Mockito.times(5)).getModel().getFrog().getPosition().getRight();
    }
}
