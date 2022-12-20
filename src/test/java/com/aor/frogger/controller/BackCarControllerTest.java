package com.aor.frogger.controller;

import com.aor.frogger.Game;
import com.aor.frogger.controller.game.BackCarController;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.game.BackCar;
import com.aor.frogger.model.game.Frog;
import com.aor.frogger.model.Position;
import com.aor.frogger.model.arena.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BackCarControllerTest {
    private BackCarController controller;

    private Frog frog;

    private Arena arena;

    private Game game;
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
        controller = new BackCarController(arena);
        game = Mockito.mock(Game.class);
    }

    @Test
    void moveMonsters() throws IOException {
        BackCar backCar = new BackCar(5, 5);
        arena.setBackCar(Arrays.asList(backCar));

        long time = 0;
        while(time <= 2000) {
            time += 500;
            controller.step(game, GUI.ACTION.NONE, time);
        }
        assertNotEquals(new Position(5, 5), backCar.getPosition());
    }
}
