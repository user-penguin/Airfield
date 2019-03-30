package model;

import figure.Circle;
import figure.Triangle;
import javafx.scene.paint.Color;
import route.Route;

import java.util.LinkedList;
import java.util.List;

public class Car extends BaseAirObject {

    private List<Circle> circles = new LinkedList<>();
    private Route route;
    private int k = 0;

    public Car(Route route, double speed) {
        super(new Triangle(), new Point(route.getAllCoordinates().get(0).getRealX(), route.getAllCoordinates().get(0).getRealY()));
        Color color = Color.color(80.0/255,200.0/255,150.0/255);
        figure.setFillColor(color);
        label.setTextFill(color);

        this.speed = speed;
        for (int i = 0; i < 15; i++) {
            circles.add(new Circle());
        }

        this.route = route;

        newVector();
    }

    private void newVector() {
        int next = (k == (route.getAllCoordinates().size() - 1))? 0 : k+1;

        Point pointNext = route.getAllCoordinates().get(next);
        Point pointK = route.getAllCoordinates().get(k);

        double x2 = (pointNext.getRealX() - pointK.getRealX()) * (pointNext.getRealX() - pointK.getRealX());
        double y2 = (pointNext.getRealY() - pointK.getRealY()) * (pointNext.getRealY() - pointK.getRealY());
        double length = Math.sqrt(x2 + y2);

        dx = (pointNext.getRealX() - pointK.getRealY()) / length / 1000 * speed;
        dy = (pointNext.getRealY() - pointK.getRealY()) / length / 1000 * speed;
    }

    @Override
    public void draw(long time) {
        figure.setPosition(point.getPxX(), point.getPxY());
        label.setTranslateX(point.getPxX() - 12);
        label.setTranslateY(point.getPxY() + 7);

        point.move(dx, dy);
        figure.setPosition(point.getPxX(), point.getPxY());


    }
}
