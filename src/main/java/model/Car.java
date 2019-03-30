package model;

import figure.Circle;
import figure.Triangle;
import javafx.scene.paint.Color;
import route.Route;

import java.util.Date;
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

        dx = (pointNext.getRealX() - pointK.getRealX()) / length * speed;
        dy = (pointNext.getRealY() - pointK.getRealY()) / length * speed;
    }

    @Override
    public void draw(long time) {
        if (route.getAllCoordinates().get(k).equals(new Point(point.getRealX(), point.getRealY()))) {
            newVector();
            k = (k == (route.getAllCoordinates().size() - 1))? 0 : k+1;
        }

        figure.setPosition(point.getPxX(), point.getPxY());
        label.setTranslateX(point.getPxX() - 12);
        label.setTranslateY(point.getPxY() + 7);

        point.move(dx, dy);
        figure.setPosition(point.getPxX(), point.getPxY());

        label.setText(point.getRealYGrad() + " " + point.getRealXGrad() + "\n" +
                "Azimuth: " + Tower.getInstance().point.azimuthNorm(this.point) + "°\n" +
                "Length: " + Tower.getInstance().point.lengthNorm(this.point) + "м");

//        Date date = new Date();
//        if (date.getTime() - lastTime.getTime() > 500) {
//            Circle circle = new Circle(r);
//            circle.setFill(javafx.scene.paint.Color.color(150.0/255,121.0/255,1));
//            circle.setCenterX(x);
//            circle.setCenterY(y);
//            circles.add(circle);
//            root.getChildren().add(circle);
//            root.getChildren().remove(circles.get(0));
//            circles.remove(0);
//
//            label.setText(text + "\nX: " + (int)x + "\nY: " + (int)y);
//            label.setTranslateX(x + 10);
//            label.setTranslateY(y + 10);
//
//            for (int i = 0; i < circles.size(); i++) {
//                circles.get(i).setFill(javafx.scene.paint.Color.color(150.0/255,121.0/255,1,  1 - 1.0/(i+1)));
//            }
//
//            root.getChildren().remove(triangle);
//            triangle = new Triangle(x, y);
//            root.getChildren().add(triangle);
//
//            lastTime = new Date();
//        }
    }
}
