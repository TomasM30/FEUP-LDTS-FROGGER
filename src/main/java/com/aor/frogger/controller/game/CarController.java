package com.aor.frogger.controller.game;

import com.aor.frogger.Game;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.Car;
import com.aor.frogger.model.Position;
import com.aor.frogger.model.arena.Arena;

import java.io.IOException;

public class CarController extends GameController{
    private long lastMovement;
    public CarController(Arena arena) {super(arena); this.lastMovement=0;}

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {

            for (Car car : getModel().getCars())
                moveCar(car, car.getPosition().getLeft());
            this.lastMovement = time;
        }
    }
    private void moveCar(Car car, Position position) {
        car.setPosition(position);
        if (getModel().getFrog().getPosition().equals(position))
            getModel().getFrog().decreaseLives();
        if(position.getX1() == 0)
            car.setPosition(new Position(getModel().getLines().get(0).size(),position.getY1()));
    }
}
