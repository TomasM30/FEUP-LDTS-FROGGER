package com.aor.frogger.model.game;


public class Rectangle {
    private Position position;
    public Rectangle(int x1, int x2, int y1, int y2) {this.position = new Position(x1,x2,y1,y2);}
    public Position getPosition() {return this.position;}
    public void setPosition(Position position) {this.position = position;}

}
