package com.aor.frogger.viewer;

import com.aor.frogger.gui.GUI;
import com.aor.frogger.model.Leaf;

public class LeafViewer implements ElementViewer<Leaf>{
    @Override
    public void draw(Leaf leaf, GUI gui) {gui.drawLeaf(leaf.getPosition());}
}


