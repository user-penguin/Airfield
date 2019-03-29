package model;

public class Point {

    private double x;

    public Point(double x, double y) {
        this.x = x;
    }

    public Point(int x, int y) {
    }

    public double getRealX() {
        return x;
    }

    public double getRealY() {
        return 0;
    }

    public double getPxX() {
        return 0;
    }

    public double getPxY() {
        return 0;
    }
}
