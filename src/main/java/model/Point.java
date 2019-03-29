package model;

import static java.lang.Math.abs;

public class Point {

    private double REAL_DELTA = 5.0;
    private int PX_WIDTH = 1366; // в пикселях
    private int PX_HEIGHT = 592; // в пикселях
    private double REAL_WIDTH = 10_000.0; // в метрах
    private double REAL_HEIGHT = 5_000.0; // в метрах

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y) {
        this.x = (double) x / PX_WIDTH * REAL_WIDTH;
        this.y = (double) y / PX_HEIGHT * REAL_HEIGHT;
    }

    public double getRealX() {
        return x;
    }

    public double getRealY() {
        return y;
    }

    public int getPxX() {
        return (int) (x / REAL_WIDTH * PX_WIDTH);
    }

    public int getPxY() {
        return (int) (y / REAL_HEIGHT * PX_HEIGHT);
    }

    @Override
    public boolean equals(Object obj) {
        Point point = (Point) obj;
        boolean eq = true;
        eq = eq && abs(point.x - x) < REAL_DELTA;
        eq = eq && abs(point.y - y) < REAL_DELTA;
        return eq;
    }
}
