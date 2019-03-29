package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @Test
    void CreateRealPointTest() {
        Point point = new Point(0.0, 0.0);
        assertEquals(0.0, point.getRealX());
        assertEquals(0.0, point.getRealY());
    }

    @Test
    void CreatePxPointTest() {
        Point point = new Point(0, 0);
        assertEquals(0.0, point.getPxX());
        assertEquals(0.0, point.getPxY());
    }

    @Test
    void GetRealPointTest() {
        Point point = new Point(10.0, 0.0);
        assertEquals(10.0, point.getRealX());
    }
}