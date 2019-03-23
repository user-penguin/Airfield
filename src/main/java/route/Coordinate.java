package route;

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
