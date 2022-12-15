package com.aor.frogger.gui;

import com.aor.frogger.model.Position;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 60);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }
    private void drawCharacter(int x, int y, char c, String color, String bcolor) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.setBackgroundColor(TextColor.Factory.fromString(bcolor));
        tg.putString(x, y + 1, "" + c);
    }

    private void drawBg(int x, int y, char c, String color){
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        if (y==2){
            tg.setBackgroundColor(TextColor.Factory.fromString("#83BB61"));
            tg.putString(x, y + 1, "$");
        }
        else if (y==1) {
            tg.setBackgroundColor(TextColor.Factory.fromString("#815438"));
            tg.putString(x, y + 1, "$");
        }
        else if (y==4 || y== 5){
            tg.setBackgroundColor(TextColor.Factory.fromString("#808080"));
            tg.putString(x, y + 1, "" + c);
        }
        else{
            tg.setBackgroundColor(TextColor.Factory.fromString("#6F4E37"));
            tg.putString(x, y + 1, "" + c);
        }
    }

    @Override
    public void drawFrog(Position position) {drawBg(position.getX1(), position.getY1(), 'H', "#00FF00");}

    @Override
    public void drawLog(Position position) {drawCharacter(position.getX1(), position.getY1(), '&', "#815438","#7FB3D5"); }

    @Override
    public void drawLeaf(Position position) {drawCharacter(position.getX1(), position.getY1(), '@', "#83BB61","#7FB3D5"); }

    @Override
    public void drawCar(Position position) {drawCharacter(position.getX1(), position.getY1(), 'C', "#0000FF","#808080"); }

    public void drawRiver(Position position) {drawCharacter(position.getX1(), position.getY1(), '-', "#013F94","#7FB3D5"); }
    public void drawRoad(Position position) {drawCharacter(position.getX1(), position.getY1(), '#', "#FFFFFF", "#808080"); }

    @Override
    public void drawDirt(Position position) {drawCharacter(position.getX1(), position.getY1(), '%', "#808080", "#6F4E37");}

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX1(), position.getY1(), text);  // usar apenas o x1 e y1
    }

    @Override
    public void clear() {screen.clear();}

    @Override
    public void refresh() throws IOException {screen.refresh();}

    @Override
    public void close() throws IOException {screen.close();}
}