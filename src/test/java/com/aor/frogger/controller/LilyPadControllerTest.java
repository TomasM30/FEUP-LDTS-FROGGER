package com.aor.frogger.controller;

import com.aor.frogger.Game;
import com.aor.frogger.controller.game.LilyPadController;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.Frog;
import com.aor.frogger.model.LilyPad;
import com.aor.frogger.model.Position;
import com.aor.frogger.model.arena.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LilyPadControllerTest {
    private LilyPadController controller;
    private Frog frog;
    private Arena arena;
    private Game game;

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
        controller = new LilyPadController(arena);
        game = Mockito.mock(Game.class);
    }

    @Test
    void moveLilyPadFrog() throws IOException {
        LilyPad lilyPad = new LilyPad(5, 3);
        arena.setLilyPads(Arrays.asList(lilyPad));

        long time = 0;
        while(time <= 2000) {
            time += 500;
            controller.step(game, GUI.ACTION.NONE, time);
        }
        assertNotEquals(new Position(5, 3), lilyPad.getPosition());
        assertEquals(frog.getPosition(),lilyPad.getPosition());
        assertEquals(frog.getLives(),10);
    }

    @Test
    void moveLilyPad() throws IOException{
        LilyPad lilyPad = new LilyPad(6, 2);
        arena.setLilyPads(Arrays.asList(lilyPad));

        long time = 0;
        while(time <= 2000) {
            time += 500;
            controller.step(game, GUI.ACTION.NONE, time);
        }
        assertNotEquals(new Position(6, 2), lilyPad.getPosition());
    }
}
