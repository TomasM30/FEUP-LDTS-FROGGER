package org.example.model.game;

public class Position {
    private final int x1;
    private final int x2;
    private final int y1;
    private final int y2;

    public Position(int x1, int x2, int y1, int y2) {
        this.x1 = x1; //mais à esquerda
        this.x2 = x2; //mais à dreita
        this.y1 = y1; //top
        this.y2 = y2; //bottom
    }
    public int getX1() {return this.x1;}
    public int getX2() {return this.x2;}
    public int getY1() {return this.y1;}
    public int getY2() {return this.y2;}
    boolean intersects(Position other) {
        return !(this.x1 > other.x2 ||
                this.x2  < other.x1 ||
                this.y1  > other.y2 ||
                this.y2 < other.y1);
    }
}
