package graphics;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import route.Route;
import vova.Draw;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.incrementExact;
import static java.lang.Math.sqrt;

public class Point implements Draw {

    private Date now;

    private AnchorPane root;

    private Triangle triangle;
    private List<Circle> circles = new LinkedList<>();
    private int n = 29;
    private double r = 2.5;

    private Label label = new Label();
    private String text;

    private Route route;
    private int k = 0;

    private double x;
    private double y;

    private double dx;
    private double dy;

    private double speed;

    public Point(double speed, Route route, TypeAuto typeAuto, String number, AnchorPane root) {
        this.root = root;
        this.text = typeAuto + "\n" + number;
        this.x = route.getAllCoordinates().get(0).getX();
        this.y = route.getAllCoordinates().get(0).getY();
        this.route = route;
        this.speed = speed;

        for (int i = 0; i < n; i++) {
            Circle circle = new Circle(r);
            circle.setFill(javafx.scene.paint.Color.color(150.0/255,121.0/255,1));
            circle.setCenterX(x);
            circle.setCenterY(y);
            circles.add(circle);
            root.getChildren().add(circle);
        }

        triangle = new Triangle(x, y);
        root.getChildren().add(triangle);
        now = new Date();
    }

    @Override
    public void draw(long time) {
        if (route.getAllCoordinates().get(k).inCoordinate(x, y)) {
            dx = newDx();
            dy = newDy();
            k = (k == (route.getAllCoordinates().size() - 1))? 0 : k+1;
        }

        x += speed * dx;
        y += speed * dy;

        Date date = new Date();
        if (date.getTime() - now.getTime() > 500) {
            Circle circle = new Circle(r);
            circle.setFill(javafx.scene.paint.Color.color(150.0/255,121.0/255,1));
            circle.setCenterX(x);
            circle.setCenterY(y);
            circles.add(circle);
            root.getChildren().add(circle);
            root.getChildren().remove(circles.get(0));
            circles.remove(0);

            label.setText(text + "\nX: " + (int)x + "\nY: " + (int)y);
            label.setTranslateX(x + 10);
            label.setTranslateY(y + 10);

            for (int i = 0; i < circles.size(); i++) {
                circles.get(i).setFill(javafx.scene.paint.Color.color(150.0/255,121.0/255,1,  1 - 1.0/(i+1)));
            }

            root.getChildren().remove(triangle);
            triangle = new Triangle(x, y);
            root.getChildren().add(triangle);

            now = new Date();
        }
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
}
