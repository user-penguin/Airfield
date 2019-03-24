package graphics;

import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import route.Route;
import vova.Draw;

import static java.lang.Math.incrementExact;
import static java.lang.Math.sqrt;

public class Point implements Draw {

    private Circle circle;

    private Label label = new Label();
    private String text;

    private Route route;
    private int k = 0;

    private double x;
    private double y;

    private double dx;
    private double dy;

    private double speed;

    public Point(double speed, Route route, String text, TypeAuto typeAuto, String number) {
        circle = new Circle(5);
        this.text = text + "\n" + typeAuto + "\n" + number;
        this.x = route.getAllCoordinates().get(0).getX();
        this.y = route.getAllCoordinates().get(0).getY();
        this.route = route;
        this.speed = speed;
    }

    @Override
    public void draw(long time) {
        if (route.getAllCoordinates().get(k).inCoordinate(x, y)) {
            dx = newDx();
            dy = newDy();
            k = (k == (route.getAllCoordinates().size() - 1))? 0 : k+1;
        }

        label.setText(text + "\nX: " + (int)x + "\nY: " + (int)y);
        label.setTranslateX(x + 10);
        label.setTranslateY(y + 10);

        x += speed * dx;
        y += speed * dy;
        circle.setCenterX(x);
        circle.setCenterY(y);
    }

    private double newDx() {
        int next = (k == (route.getAllCoordinates().size() - 1))? 0 : k+1;
        return (route.getAllCoordinates().get(next).getX() - route.getAllCoordinates().get(k).getX()) / getLength();
    }

    private double newDy() {
        int next = (k == (route.getAllCoordinates().size() - 1))? 0 : k+1;
        return (route.getAllCoordinates().get(next).getY() - route.getAllCoordinates().get(k).getY()) / getLength();
    }

    private double getLength() {
        int next = (k == (route.getAllCoordinates().size() - 1))? 0 : k+1;
        double xx = route.getAllCoordinates().get(next).getX() - route.getAllCoordinates().get(k).getX();
        xx *= xx;
        double yy = route.getAllCoordinates().get(next).getY() - route.getAllCoordinates().get(k).getY();
        yy *= yy;
        return sqrt(xx + yy);
    }

    @Override
    public Label getLabel() {
        return label;
    }

    public Circle getCircle() {
        return circle;
    }
}
