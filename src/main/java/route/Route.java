package route;

import vova.Point;

import java.util.ArrayList;

public class Route {

    private ArrayList<Point> route = new ArrayList<>();

    public void addCoordinate (Point coordinate) {
        this.route.add(coordinate);
    }

    public ArrayList<Point> getAllCoordinates () {
        return route;
    }

}
