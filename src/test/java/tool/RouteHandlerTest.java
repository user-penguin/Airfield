package tool;

import org.junit.Test;
import route.Route;
import vova.Point;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RouteHandlerTest {
    @Test
    public void readingWayTest () {
        RouteHandler routeHandler = new RouteHandler();
        Route route = routeHandler.readRoute("test_way");
        Point[] actualCoordinates = new Point[2];
        actualCoordinates[0] = new Point(1,2);
        actualCoordinates[1] = new Point(3, 4);
        ArrayList<Point> expectedCoordinates = route.getAllCoordinates();
        for (int i = 0; i < 2; i++) {
            assertEquals(actualCoordinates[i], expectedCoordinates.get(i));
        }
    }
}