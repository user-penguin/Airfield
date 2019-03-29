package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @Test
    void CreatePointTest() {
        Point point = new Point();
    }

    @Test
    void CreateRealPointTest() {
        Point point = new Point(0.0, 0.0);
    }
}