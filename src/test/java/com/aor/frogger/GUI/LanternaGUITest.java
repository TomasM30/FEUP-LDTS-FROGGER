package com.aor.frogger.GUI;

import com.aor.frogger.gui.LanternaGUI;
import com.aor.frogger.model.game.River;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        gui = new LanternaGUI(screen);
    }


    @Test
    void drawElements() {
        gui.drawFrog(new River.Position(5, 10));
        gui.drawCar(new River.Position(3,8));
        gui.drawDirt(new River.Position(2,6));
        gui.drawLog(new River.Position(7,4));
        gui.drawRiver(new River.Position(3, 9));
        gui.drawBackCar(new River.Position(2,8));
        gui.drawLilyPad(new River.Position(1,7));
        gui.drawRoad(new River.Position(8,9));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(0,255,0));
        Mockito.verify(tg, Mockito.times(1)).putString(5, 11, "H");
        Mockito.verify(tg, Mockito.times(1)).putString(3, 9, "C");
        Mockito.verify(tg, Mockito.times(1)).putString(2, 7, "%");
        Mockito.verify(tg, Mockito.times(1)).putString(7,5 , "&");
        Mockito.verify(tg, Mockito.times(1)).putString(3, 10, "-");
        Mockito.verify(tg, Mockito.times(1)).putString(2, 9, "A");
        Mockito.verify(tg, Mockito.times(1)).putString(1, 8, "@");
        Mockito.verify(tg, Mockito.times(1)).putString(8, 10, "#");
    }

    @Test
    void drawText() {
        gui.drawText(new River.Position(1, 1), "Hello World", "#336699");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Hello World");
    }
}
