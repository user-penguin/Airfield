package model;

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
        this.y = REAL_HEIGHT - (double) y / PX_HEIGHT * REAL_HEIGHT;
    }

    public double getRealX() {
        return x;
    }

    public double getRealY() {
        return y;
    }

    public double getRealXNorm() {
        return Math.round(x*100)/100;
    }

    public double getRealYNorm() {
        return Math.round(y*100)/100;
    }

    public int getPxX() {
        return (int) (x / REAL_WIDTH * PX_WIDTH);
    }

    public int getPxY() {
        return PX_HEIGHT - (int) (y / REAL_HEIGHT * PX_HEIGHT);
    }

    @Override
    public boolean equals(Object obj) {
        Point point = (Point) obj;
        boolean eq = true;
        eq = eq && Math.abs(point.x - x) < REAL_DELTA;
        eq = eq && Math.abs(point.y - y) < REAL_DELTA;
        return eq;
    }

    public double length(Point point) {
        double dx = x - point.x;
        double dy = y - point.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    double corner(Point point) {
        double length = length(point);
        double dx = point.x - x;
        double dy = point.y - y;
        double sin = dy / length;
        double cos = dx / length;

        double asin = Math.asin(sin) * 180 / Math.PI;
        double acos = Math.acos(cos) * 180 / Math.PI;

        if (sin >= 0 && cos >= 0) {
            return asin;
        } else if (sin > 0 && cos < 0) {
            return acos;
        } if (sin < 0 && cos >= 0) {
            return 360 + asin;
        } else {
            return 360 - acos;
        }
    }

    /**
     * Считает азимут от данной точки в градусах
     * @param point базовая точка
     * @return азимут от 0 до 360 градусов
     */
    public double azimuth(Point point) {
        double ret = 360 - corner(point) + 90;
        if (ret >= 360) {
            ret -= 360;
        }
        return ret;
    }

    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }
}
