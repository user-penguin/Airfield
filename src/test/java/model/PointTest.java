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
}