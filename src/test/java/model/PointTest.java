package model;

import org.junit.jupiter.api.Test;

import static java.lang.StrictMath.sqrt;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    private int PX_DELTA = 5;
    private double REAL_DELTA = 5.0;
    private double CORNER_DELTA = 2.0;

    @Test
    void CreateRealPointTest() {
        Point point = new Point(0.0, 0.0);
    }

    @Test
    void CreatePxPointTest() {
        Point point = new Point(0, 0);
    }

    @Test
    void GetRealXFromRealPointTest() {
        Point point = new Point(10.0, 0.0);
        assertEquals(10.0, point.getRealX());
    }

    @Test
    void GetRealYFromRealPointTest() {
        Point point = new Point(0.0, 10.0);
        assertEquals(10.0, point.getRealY());
    }

    @Test
    void GetPxXFromRealPointTest() {
        Point point = new Point(10_000.0, 0.0);
        assertEquals(1366, point.getPxX(), PX_DELTA);
    }

    @Test
    void GetPxYFromRealPointTest() {
        Point point = new Point(0.0, 5_000.0);
        assertEquals(0, point.getPxY(), PX_DELTA);
    }

    @Test
    void GetRealXFromPxPointTest() {
        Point point = new Point(1366, 0);
        assertEquals(10_000.0, point.getRealX(), REAL_DELTA);
    }

    @Test
    void GetRealYFromPxPointTest() {
        Point point = new Point(0, 0);
        assertEquals(5_000.0, point.getRealY(), REAL_DELTA);
    }

    @Test
    void EqualsPointTest() {
        double[] points = new double[] {
            1, 1, 1, 1,
            1, 1, 2, 1,
            1, 1, 3, 1,
            1, 1, 1, 2,
            1, 1, 1, 3,
        };
        for (int i = 0; i < points.length / 4; i += 4) {
            assertEquals(new Point(points[i], points[i+1]), new Point(points[i+2], points[i+3]));
        }
    }

    @Test
    void GetLength() {
        Point tower = new Point(0.0, 0.0);
        Point point = new Point(10.0, 10.0);
        assertEquals(10 * Math.sqrt(2), tower.length(point));
    }

    @Test
    void GetCorner() {
        Point tower = new Point(0.0, 0.0);

        Point point01 = new Point(0.0, 10.0);
        assertEquals(0.0, tower.corner(point01), CORNER_DELTA);

        Point point02 = new Point(10.0, 0.0);
        assertEquals(90.0, tower.corner(point02), CORNER_DELTA);

        Point point03 = new Point(0.0, -10.0);
        assertEquals(180.0, tower.corner(point03), CORNER_DELTA);

        Point point04 = new Point(-10.0, 0.0);
        assertEquals(270.0, tower.corner(point04), CORNER_DELTA);

        Point point1 = new Point(10.0, 10.0);
        assertEquals(45.0, tower.corner(point1), CORNER_DELTA);

        Point point2 = new Point(10.0, -10.0);
        assertEquals(135.0, tower.corner(point2), CORNER_DELTA);

        Point point3 = new Point(-10.0, -10.0);
        assertEquals(225.0, tower.corner(point3), CORNER_DELTA);

        Point point4 = new Point(-10.0, 10.0);
        assertEquals(315.0, tower.corner(point4), CORNER_DELTA);
    }
}