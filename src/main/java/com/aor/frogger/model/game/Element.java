package com.aor.frogger.model.game;


public class Element {
    private River.Position position;
    public Element(int x1, int y1) {this.position = new River.Position(x1,y1);}
    public River.Position getPosition() {return this.position;}
    public void setPosition(River.Position position) {this.position = position;}

}
