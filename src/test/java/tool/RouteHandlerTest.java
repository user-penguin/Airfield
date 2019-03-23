package tool;

import org.junit.Test;
import route.Coordinate;
import route.Route;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RouteHandlerTest {
    @Test
    public void readingWayTest () {
        RouteHandler routeHandler = new RouteHandler();
        Route route = routeHandler.readRoute("test_way");
        Coordinate[] actualCoordinates = new Coordinate[2];
        actualCoordinates[0] = new Coordinate(1,2);
        actualCoordinates[1] = new Coordinate(3, 4);
        ArrayList<Coordinate> expectedCoordinates = route.getAllCoordinates();
        for (int i = 0; i < 2; i++) {
            assertEquals(actualCoordinates[i], expectedCoordinates.get(i));
        }
    }

    @Test
    public void creatingWayTest () {
        RouteHandler routeHandler = new RouteHandler();
        Route route = new Route();
        route.addCoordinate(new Coordinate(1,2));
        route.addCoordinate(new Coordinate(5,6));
        routeHandler.writeRoute(route, "32");
        Route expectedRoute = routeHandler.readRoute("32");
        for (int i = 0; i < 2; i++) {
            assertEquals(route.getAllCoordinates().get(i), expectedRoute.getAllCoordinates().get(i));
        }
    }
}