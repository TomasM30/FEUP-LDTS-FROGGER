package com.aor.frogger.controller.game;

import com.aor.frogger.Game;
import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.Leaf;
import com.aor.frogger.model.Position;
import com.aor.frogger.model.arena.Arena;

import java.io.IOException;

public class LeafController extends GameController{
    private long lastMovement;
    public LeafController(Arena arena) {super(arena);this.lastMovement=0;}

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {

            for (Leaf leaf : getModel().getLeaves())
                moveLeaf(leaf, leaf.getPosition().getLeft());
            this.lastMovement = time;
        }
    }
    private void moveLeaf(Leaf leaf, Position position) {
        leaf.setPosition(position);
        if(position.getX1() == 0)
            leaf.setPosition(new Position(getModel().getLines().get(0).size(),position.getY1()));
    }
}
