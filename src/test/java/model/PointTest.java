package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    private int PX_DELTA = 5;
    private double REAL_DELTA = 5.0;

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
        assertEquals(592, point.getPxY(), PX_DELTA);
    }

    @Test
    void GetRealXFromPxPointTest() {
        Point point = new Point(1366, 0);
        assertEquals(10_000.0, point.getRealX(), REAL_DELTA);
    }

    @Test
    void GetRealYFromPxPointTest() {
        Point point = new Point(0, 592);
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
}