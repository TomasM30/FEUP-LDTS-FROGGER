package com.aor.frogger.model;


public class Element {
    private Position position;
    public Element(int x1, int y1) {this.position = new Position(x1,y1);}
    public Position getPosition() {return this.position;}
    public void setPosition(Position position) {this.position = position;}

}
