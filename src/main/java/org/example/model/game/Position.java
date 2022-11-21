package org.example.model.game;

public class Position {
    private final float x1;
    private final float x2;
    private final float y1;
    private final float y2;

    public Position(float x1, float x2, float y1, float y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1; //top
        this.y2 = y2; //bottom
    }
    boolean intersects(Position other) {
        return !(this.x1 > other.x2 ||
                this.x2  < other.x1 ||
                this.y1  > other.y2 ||
                this.y2 < other.y1);
    }

}
