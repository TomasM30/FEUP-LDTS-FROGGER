package com.aor.frogger.viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.Car;

public class CarViewer implements ElementViewer<Car>{
    @Override
    public void draw(Car car, GUI gui) {
        gui.drawCar(car.getPosition());
    }
}
