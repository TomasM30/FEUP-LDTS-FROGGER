package com.aor.frogger.viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.Leaf;

public class LeafViewer implements RectangleViewer<Leaf>{
    @Override
    public void draw(Leaf leaf, GUI gui) {gui.drawLeaf(leaf.getPosition());}
}


