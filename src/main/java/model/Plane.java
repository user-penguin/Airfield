package model;

import figure.Circle;
import figure.Figure;
import figure.Rhombus;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import route.Route;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Plane extends BaseAirObject {

    private List<Circle> circles = new LinkedList<>();
    private Route route;
    private int k = 0;
    private Color color;

    public Plane(Route route) {
        super(new Rhombus(), new Point(route.getAllCoordinates().get(0).getPxX(), route.getAllCoordinates().get(0).getPxY(), route.getAllCoordinates().get(0).getRealZ(), route.getAllCoordinates().get(0).getSpeed()));
        color = Color.color(50.0/255,200.0/255,50.0/255);
        figure.setFillColor(color);
        label.setTextFill(color);

        this.speed = route.getAllCoordinates().get(0).getSpeed();
        for (int i = 0; i < 15; i++) {
            circles.add(new Circle());
        }

        this.route = route;
        lastTime = new Date();
        lastTime1 = new Date();

        newVector();
    }

    private void newVector() {
        if (k < route.getAllCoordinates().size() - 1) {
            int next = (k == (route.getAllCoordinates().size() - 1)) ? 0 : k + 1;

            Point pointNext = route.getAllCoordinates().get(next);
            Point pointK = route.getAllCoordinates().get(k);

            double x2 = (pointNext.getRealX() - pointK.getRealX()) * (pointNext.getRealX() - pointK.getRealX());
            double y2 = (pointNext.getRealY() - pointK.getRealY()) * (pointNext.getRealY() - pointK.getRealY());
            double z2 = (pointNext.getRealZ() - pointK.getRealZ()) * (pointNext.getRealZ() - pointK.getRealZ());
            double length = Math.sqrt(x2 + y2 + z2);

            speed = pointNext.getSpeed();
            dx = (pointNext.getRealX() - pointK.getRealX()) / length * speed;
            dy = (pointNext.getRealY() - pointK.getRealY()) / length * speed;
            dz = (pointNext.getRealZ() - pointK.getRealZ()) / length * speed;
        } else {
            dx = dy = dz = 0;
        }
    }

    @Override
    public void draw(long time, AnchorPane root) {
        if (new Date().getTime() - lastTime1.getTime() > 1) {
            if (route.getAllCoordinates().get(k).equals(new Point(point.getRealX(), point.getRealY()))) {
                newVector();
                k = (k == (route.getAllCoordinates().size() - 1)) ? 0 : k + 1;
            }

            figure.setPosition(point.getPxX(), point.getPxY());
            label.setTranslateX(point.getPxX() - 12);
            label.setTranslateY(point.getPxY() + 7);

            point.move(dx, dy, dz);
            figure.setPosition(point.getPxX(), point.getPxY());

            label.setText(point.getRealYGrad() + " " + point.getRealXGrad() + "\n" +
                    "Azimuth: " + Tower.getInstance().point.azimuthNorm(this.point) + "°\n" +
                    "Length: " + Tower.getInstance().point.lengthNorm(this.point) + "м\n" +
                    "Height: " + point.getRealZNorm());

            Date date = new Date();
            if (date.getTime() - lastTime.getTime() > 500) {
                Circle circle = new Circle();
                circle.setFill(color);
                circle.setCenterX(point.getPxX());
                circle.setCenterY(point.getPxY());
                circles.add(circle);
                root.getChildren().add(circle);
                root.getChildren().remove(circles.get(0));
                circles.remove(0);

                for (int i = 0; i < circles.size(); i++) {
                    circles.get(i).setFill(new Color(color.getRed(), color.getGreen(), color.getBlue(), 1 - 1.0 / (i + 1)));
                }

                lastTime = new Date();
            }
            lastTime1 = new Date();
        }
    }
}
