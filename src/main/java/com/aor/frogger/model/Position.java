package com.aor.frogger.model;

import java.util.Objects;

public class Position {
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
            if (!(o instanceof Position)) return false;
            Position position = (Position) o;
            return x1 == position.getX1() && y1 == position.getY1();
        }
        @Override
        public int hashCode() {
        return Objects.hash(x1, y1);
    }
}

