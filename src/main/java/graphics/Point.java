package graphics;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import route.Coordinate;
import route.Route;
import vova.Draw;

public class Point extends Circle implements Draw {

    private Route route;
    private int k = 0;

    private int x;
    private int y;

    private int dx;
    private int dy;

    private int speed;

    public Point(int x, int y, int dx, int dy, int speed, Route route) {
        super(5);
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.speed = speed;
        this.route = route;
    }

    @Override
    public void draw(long time) {
        if (route.getAllCoordinates().get(k).inCoordinate(x, y)) {
            k++;
            dx = newDx();
            dy = newDy();
        }

        x += speed * dx;
        y += speed * dy;
        setCenterX(x);
        setCenterY(y);
    }

    private int newDx() {
        int next = (k == route.getAllCoordinates().size() - 1)? 0 : k+1;
        return route.getAllCoordinates().get(next).getX() - route.getAllCoordinates().get(k).getX();
    }

    private int newDy() {
        int next = (k == route.getAllCoordinates().size() - 1)? 0 : k+1;
        return route.getAllCoordinates().get(next).getY() - route.getAllCoordinates().get(k).getY();
    }
}
