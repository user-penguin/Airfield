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
        dx = (route.getAllCoordinates().get(next).getRealX() - route.getAllCoordinates().get(k).getRealY()) / getLength();
        dy = (route.getAllCoordinates().get(next).getRealY() - route.getAllCoordinates().get(k).getRealY()) / getLength();
    }

    @Override
    public void draw(long time) {
        figure.setPosition(point.getPxX(), point.getPxY());
        label.setTranslateX(point.getPxX() - 12);
        label.setTranslateY(point.getPxY() + 7);

        point.move(dx, dy);
        figure.setPosition(point.getPxX(), point.getPxY());
    }


    private double getLength() {
        int next = (k == (route.getAllCoordinates().size() - 1))? 0 : k+1;
        double xx = route.getAllCoordinates().get(next).getRealX() - route.getAllCoordinates().get(k).getRealX();
        xx *= xx;
        double yy = route.getAllCoordinates().get(next).getRealY() - route.getAllCoordinates().get(k).getRealY();
        yy *= yy;
        return Math.sqrt(xx + yy);
    }
}
