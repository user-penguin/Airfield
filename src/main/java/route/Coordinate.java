package route;

import static java.lang.StrictMath.abs;

public class Coordinate extends Object{
    private int x;
    private int y;

    public Coordinate (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean inCoordinate(int x, int y) {
        return abs(x - this.x) < 0.01 && abs(y - this.y) < 0.01;
    }

    @Override
    public boolean equals(Object object) {
        Coordinate coordinate = (Coordinate) object;
        if (this.x != coordinate.getX()) {
            return false;
        }
        if (this.y != coordinate.getY()) {
            return false;
        }
        return true;
    }
}
