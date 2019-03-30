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
        for (int i = 0; i < points.length; i += 4) {
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

        double[] points = new double[] {
                90, 0, 10,
                0, 10, 0,
                270, 0, -10,
                180, -10, 0,

                45, 10, 10,
                315, 10, -10,
                225, -10, -10,
                135, -10, 10,

                30, 5 * Math.sqrt(3), 5,
                150, -5 * Math.sqrt(3), 5,
                210, -5 * Math.sqrt(3), -5,
                330, 5 * Math.sqrt(3), -5,
        };

        for (int i = 0; i < points.length; i += 3) {
            assertEquals(points[i], tower.corner(new Point(points[i+1], points[i+2])), CORNER_DELTA);
        }
    }

    @Test
    void GetAzimuth() {
        Point tower = new Point(0.0, 0.0);

        double[] points = new double[] {
                0, 0, 10,
                90, 10, 0,
                180, 0, -10,
                270, -10, 0,

                45, 10, 10,
                135, 10, -10,
                225, -10, -10,
                315, -10, 10,

                60, 5 * Math.sqrt(3), 5,
                300, -5 * Math.sqrt(3), 5,
                240, -5 * Math.sqrt(3), -5,
                120, 5 * Math.sqrt(3), -5,
        };

        for (int i = 0; i < points.length; i += 3) {
            assertEquals(points[i], tower.azimuth(new Point(points[i+1], points[i+2])), CORNER_DELTA);
        }
    }
}