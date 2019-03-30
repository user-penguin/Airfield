package figure;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Triangle extends Polygon implements Figure {

    public Triangle() {
        getPoints().setAll(
                +0 + getTranslateX(), -5 + getTranslateY(),
                +6 + getTranslateX(), +5 + getTranslateY(),
                -6 + getTranslateX(), +5 + getTranslateY()
        );
    }

    public void setPosition(int pxX, int pxY) {
        getPoints().setAll(
                +0 + (double)pxX, -5 + (double)pxY,
                +6 + (double)pxX, +5 + (double)pxY,
                -6 + (double)pxX, +5 + (double)pxY
        );
    }

    @Override
    public void setFillColor(Color color) {
        setFill(color);
    }
}
