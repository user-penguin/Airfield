package vova;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.abs;

public class Point extends MainPoint {

    public Point(double x, double y) {
        super(x, y);
    }

    public Point(int x, int y) {
        super(x, y);
    }

    public double getLengthReal(Point point) {
        double dx = point.getXReal() - getXReal();
        double dy = point.getYReal() - getYReal();
        return sqrt(dx*dx + dy*dy);
    }

    public boolean inCoordinate(double x, double y) {
        return abs(x - this.x) < DELTA && abs(y - this.y) < DELTA;
    }

    @Override
    public boolean equals(Object obj) {
        MainPoint mainPoint = (MainPoint) obj;
        return x == mainPoint.getXReal() && y == mainPoint.getYReal();
    }
}
