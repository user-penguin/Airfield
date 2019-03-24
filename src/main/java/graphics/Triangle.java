package graphics;

import javafx.scene.shape.Polygon;

public class Triangle extends Polygon {

    public Triangle(double x, double y) {
        setFill(javafx.scene.paint.Color.color(150.0/255,121.0/255,1));
        getPoints().setAll(
                0 + x, -5 + y,
                6 + x, 5 + y,
                -6 + x, 5 + y
        );
    }

}
