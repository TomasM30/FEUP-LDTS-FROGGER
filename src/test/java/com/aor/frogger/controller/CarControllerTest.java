package com.aor.frogger.controller;

import com.aor.frogger.Game;
import com.aor.frogger.controller.game.CarController;
import com.aor.frogger.controller.game.FrogController;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.arena.Arena;
import com.aor.frogger.model.game.Car;
import com.aor.frogger.model.game.Frog;
import com.aor.frogger.model.game.River;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CarControllerTest {
    private CarController controller;
    private Frog frog;
    private Arena arena;
    private Game game;
    private FrogController controller2;


    @BeforeEach
    void setup() {
        arena = new Arena(11,11);
        frog = new Frog(5,10,1);
        arena.setFrog(frog);
        arena.setCars(Arrays.asList());
        arena.setLogs(Arrays.asList());
        arena.setDirts(Arrays.asList());
        arena.setBackCar(Arrays.asList());
        arena.setRoads(Arrays.asList());
        arena.setRivers(Arrays.asList());
        arena.setLilyPads(Arrays.asList());
        arena.setLines(Arrays.asList());
        controller = new CarController(arena);
        controller2 = new FrogController(arena);
        game = Mockito.mock(Game.class);
    }

    @Test
    void moveCars() throws IOException{
        //game.setState(new GameState(arena));
        Car car1 = new Car( 4,5);
        Car car2 = new Car (9,6);
        arena.setCars(Arrays.asList(car1,car2));
        long time = 0;
        while(time < 2000) {
            time += 500;
            controller.step(game, GUI.ACTION.NONE,time);
            controller2.step(game,GUI.ACTION.UP,time);
        }
        assertNotEquals(new River.Position(4,5),car1.getPosition());
        assertNotEquals(new River.Position(3,6),car2.getPosition());
        assertEquals(new River.Position(5,10),frog.getPosition());
        //Mockito.verify(game, Mockito.times(1)).setState(new GameOverState(new GameOver()));
    }
}
