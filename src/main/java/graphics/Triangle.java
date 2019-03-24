package graphics;

import javafx.scene.shape.Polygon;

import java.util.LinkedList;
import java.util.List;

public class Triangle extends Polygon {

    private double x;
    private double y;

    public Triangle(double x, double y) {
        this.x = x;
        this.y = y;
        setFill(javafx.scene.paint.Color.color(150.0/255,121.0/255,1));
        getPoints().setAll(new Double[]{
                Double.valueOf(0), Double.valueOf(-5),
                Double.valueOf(6), Double.valueOf(5),
                Double.valueOf(-6), Double.valueOf(5),
        });
    }

    public void setCenter(double x, double y) {
        double dx = x - this.x;
        double dy = y - this.y;
        this.x = x;
        this.y = y;

        List<Double> list = new LinkedList<>();

        for (int i = 0; i < getPoints().size(); i += 2) {
            list.add(getPoints().get(i) + dx);
            list.add(getPoints().get(i + 1) + dy);
        }

        getPoints().setAll(list);
    }

}
