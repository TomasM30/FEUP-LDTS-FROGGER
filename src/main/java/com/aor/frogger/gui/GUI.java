package com.aor.frogger.gui;

import com.aor.frogger.model.game.River;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawFrog(River.Position position);

    void drawLog(River.Position position);

    void drawLilyPad(River.Position position);

    void drawCar(River.Position position);
    void drawBackCar(River.Position position);

    void drawText(River.Position position, String text, String color);

    void drawRiver(River.Position position);

    void drawRoad(River.Position position);
    void drawDirt(River.Position position);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;


    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}