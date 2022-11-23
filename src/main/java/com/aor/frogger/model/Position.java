package com.aor.frogger.model;

public class Position {
    private int x1;

    private int x2;
    private int y1;
    private int y2;

    public Position(int x1, int x2, int y1, int y2) {
        this.x1 = x1; //mais à esquerda
        this.x2 = x2; //mais à dreita
        this.y1 = y1; //top
        this.y2 = y2; //bottom
    }
    public Position(int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;
    }
    public int getX1() {return this.x1;}
    public int getX2() {return this.x2;}
    public int getY1() {return this.y1;}
    public int getY2() {return this.y2;}
    public boolean intersects(Position other) {
        return !(this.x1 >= other.x2 ||
                this.x2  <= other.x1 ||
                this.y1  >= other.y2 ||
                this.y2 <= other.y1);
    }
    public Position getLeft() {
        return new Position(x1-1,x2-1,y1,y2);
    }

    public Position getRight() {
        return new Position(x1 + 1,x2+1,y1, y2);
    }

    public Position getUp() {
        return new Position(x1,x2,y1 - 1,y2-1);
    }

    public Position getDown() {
        return new Position(x1,x2,y1 + 1,y2+1);
    }
}
