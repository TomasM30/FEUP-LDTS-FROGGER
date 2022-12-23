package com.aor.frogger.controller;

import com.aor.frogger.controller.game.FrogController;
import com.aor.frogger.model.Position;
import com.aor.frogger.model.arena.Arena;
import com.aor.frogger.model.game.Frog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrogControllerTest {
    private FrogController controller;

    private Frog frog;

    private Arena arena;

    @BeforeEach
    void setup() {
        arena = new Arena(11,11);

        frog = new Frog(5,10,10);

        arena.setFrog(frog);
        arena.setCars(Arrays.asList());
        arena.setLogs(Arrays.asList());
        arena.setDirts(Arrays.asList());
        arena.setBackCar(Arrays.asList());
        arena.setRoads(Arrays.asList());
        arena.setRivers(Arrays.asList());
        arena.setLilyPads(Arrays.asList());
        arena.setLines(Arrays.asList());
        controller = new FrogController(arena);
    }

    @Test
    void moveFrogLeft() {
        controller.moveFrogLeft();
        assertEquals(new Position(4,10), frog.getPosition());
    }

    @Test
    void moveFrogUp() {
        controller.moveFrogUp();
        assertEquals(new Position(5,9),frog.getPosition());
    }

    @Test
    void moveFrogDown() {
        controller.moveFrogDown();
        assertEquals(new Position(5,10), frog.getPosition());
    }

    @Test
    void moveFrogRight() {
        controller.moveFrogRight();
        assertEquals(new Position(6,10), frog.getPosition());
    }
}
