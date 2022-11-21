package org.example.model.game;


import org.example.model.game.Position;

public class Rectangle {
    private Position position;
    public Rectangle(float x1, float x2, float y1, float y2) {this.position = new Position(x1,x2,y1,y2);}
    public Position getPosition() {return this.position;}
    public void setPosition(Position position) {this.position = position;}

}
