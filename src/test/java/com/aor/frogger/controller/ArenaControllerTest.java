package com.aor.frogger.controller;

import com.aor.frogger.Game;
import com.aor.frogger.controller.game.*;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.arena.Arena;
import com.aor.frogger.model.game.*;
import com.aor.frogger.states.GameOverState;
import com.aor.frogger.states.GameWonState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class ArenaControllerTest {
    private Arena arena;
    private FrogController controllerf;
    private CarController controllerc;
    private BackCarController controllerbc;
    private LogController controllerl;
    private LilyPadController controllerlp;
    private ArenaController controllerA;
    private Game game;

    @BeforeEach
    void setup() {
        arena = new Arena(11,11);
        controllerA = new ArenaController(arena);
        controllerf = new FrogController(arena);
        controllerc = new CarController(arena);
        controllerbc = new BackCarController(arena);
        controllerl = new LogController(arena);
        controllerlp = new LilyPadController(arena);
        arena.setLogs(Arrays.asList(new Log(2,1), new Log(6,2), new Log(4,2)));
        arena.setCars(Arrays.asList(new Car(4,9), new Car(7,8), new Car(2,7)));
        arena.setDirts(Arrays.asList(new Dirt(2,0), new Dirt(6,5), new Dirt(4,10)));
        arena.setBackCar(Arrays.asList(new BackCar(5,9), new BackCar(8,8), new BackCar(3,7)));
        arena.setRoads(Arrays.asList(new Road(2,9),new Road(1,8), new Road(9,7)));
        arena.setRivers(Arrays.asList(new River(6,4), new River(5,2), new River(1,1)));
        arena.setLilyPads(Arrays.asList(new LilyPad(7,4), new LilyPad(1,4), new LilyPad(2,3)));
        game = Mockito.mock(Game.class);
    }
    @Test
    void GameOver() throws IOException {
        Frog frog = new Frog(7,2,0);
        arena.setFrog(frog);
        long time = 0;
        controllerA.step(game, GUI.ACTION.NONE, time);
        Mockito.verify(game,Mockito.times(0)).setState(new GameOverState(new GameOver()));
    }
    @Test
    void GameWon() throws IOException{
        Frog frog = new Frog(7,0,1);
        arena.setFrog(frog);
        long time = 0;
        controllerA.step(game, GUI.ACTION.NONE, time);
        Mockito.verify(game,Mockito.times(0)).setState(new GameWonState(new GameWon()));
    }
}