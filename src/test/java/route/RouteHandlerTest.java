package route;

import model.Point;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RouteHandlerTest {
    @Test
    public void readingWayTest () {
        Route route = RouteHandler.readRoute("test_way");
        Point[] actualCoordinates = new Point[2];
        actualCoordinates[0] = new Point(1,2);
        actualCoordinates[1] = new Point(3, 4);
        ArrayList<Point> expectedCoordinates = route.getAllCoordinates();
        for (int i = 0; i < 2; i++) {
            assertEquals(actualCoordinates[i], expectedCoordinates.get(i));
        }
    }

    @Test
    public void readingSpeedTest () {
        int expected = RouteHandler.readSpeed("testSpeed");
        int actual = 30;
        assertEquals(expected, actual);
    }
}