package model;

public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y) {
    }

    public double getRealX() {
        return x;
    }

    public double getRealY() {
        return y;
    }

    public double getPxX() {
        return 0;
    }

    public double getPxY() {
        return 0;
    }
}
