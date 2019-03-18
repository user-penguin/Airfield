package route;

import java.util.ArrayList;

public interface IRoute {
    public void addCoordinate (Coordinate coordinate);
    public ArrayList<Coordinate> getAllCoordinates();
    public double calculateDuration ();
}
