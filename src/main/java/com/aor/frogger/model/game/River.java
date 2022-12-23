package com.aor.frogger.model.game;

public class River extends Element {
    public River(int x, int y) { super(x,y);}

    public static class Position {
        private int x1;

        private int y1;
        public Position(int x1, int y1) {
            this.x1 = x1;
            this.y1 = y1;
        }
        public int getX1() {return this.x1;}

        public int getY1() {return this.y1;}


        public Position getLeft() {
            return new Position(x1-1,y1);
        }

        public Position getRight() {
            return new Position(x1 + 1,y1);
        }

        public Position getUp() {
            return new Position(x1,y1 - 1);
        }

        public Position getDown() {
            return new Position(x1,y1 + 1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x1 == position.getX1() && y1 == position.getY1();
        }
    }
}
