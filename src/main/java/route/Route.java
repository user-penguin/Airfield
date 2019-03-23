package route;

import java.util.ArrayList;

public class Route implements IRoute {
    private ArrayList<Coordinate> route;

    public Route () {
        this.route = new ArrayList<>();
    }

    public void addCoordinate (Coordinate coordinate) {
        this.route.add(coordinate);
    }

    public ArrayList<Coordinate> getAllCoordinates () {
        return route;
    }

    public double calculateDuration () {
        return 0;
    }
}
