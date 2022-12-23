package com.aor.frogger.controller;

import com.aor.frogger.controller.game.FrogController;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.arena.Arena;
import com.aor.frogger.model.game.*;
import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;

import java.util.Arrays;
import java.util.List;

public class ArenaClosedTest {

    @Property
    void allArenasAreClosed(@ForAll @IntRange(min = 3, max = 50) int width, @ForAll @IntRange(min = 3, max = 50) int height, @ForAll List<GUI.@From("moveActions") ACTION> actions) {
        Arena arena = new Arena(10,10);
        FrogController controller = new FrogController(arena);
        arena.setFrog(new Frog(5,10,3));
        arena.setCars(Arrays.asList(new Car(4,9), new Car(7,8), new Car(2,7)));
        arena.setLogs(Arrays.asList(new Log(2,1), new Log(6,2), new Log(4,2)));
        arena.setDirts(Arrays.asList(new Dirt(2,0), new Dirt(6,5), new Dirt(4,10)));
        arena.setBackCar(Arrays.asList(new BackCar(5,9), new BackCar(8,8), new BackCar(3,7)));
        arena.setRoads(Arrays.asList(new Road(2,9),new Road(1,8), new Road(9,7)));
        arena.setRivers(Arrays.asList(new River(6,4), new River(5,2), new River(1,1)));
        arena.setLilyPads(Arrays.asList(new LilyPad(7,4), new LilyPad(1,4), new LilyPad(2,3)));
        for (GUI.ACTION action : actions) {
            controller.step(null, action, 100);
            try {
                assert (controller.getModel().getFrog().getPosition().getX1() > 0);
                assert (controller.getModel().getFrog().getPosition().getY1() > 0);
                assert (controller.getModel().getFrog().getPosition().getX1() < width - 1);
                assert (controller.getModel().getFrog().getPosition().getY1() < height - 1);
            } catch (AssertionError e){
            }
        }
    }

    @Provide
    Arbitrary<GUI.ACTION> moveActions() {
        return Arbitraries.of(GUI.ACTION.UP, GUI.ACTION.RIGHT, GUI.ACTION.DOWN, GUI.ACTION.LEFT);
    }
}
