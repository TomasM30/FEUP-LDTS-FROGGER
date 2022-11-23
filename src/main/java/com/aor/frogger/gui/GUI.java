package com.aor.frogger.gui;

import com.aor.frogger.model.game.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawFrog(Position position);

    void drawLog(Position position);

    void drawLeaf(Position position);

    void drawCar(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}