package figure;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Rhombus extends Polygon implements Figure {

    private int r = 5;

    public Rhombus() {
        getPoints().setAll(
                +0 + getTranslateX(), +r + getTranslateY(),
                +r + getTranslateX(), +0 + getTranslateY(),
                +0 + getTranslateX(), -r + getTranslateY()
                -r + getTranslateX(), +0 + getTranslateY()
        );
    }

    @Override
    public void setPosition(int pxX, int pxY) {
        getPoints().setAll(
                +0 + (double)pxX, +r + (double)pxY,
                +r + (double)pxX, +0 + (double)pxY,
                +0 + (double)pxX, -r + (double)pxY,
                -r + (double)pxX, +0 + (double)pxY
        );
    }

    @Override
    public void setFillColor(Color color) {
        setFill(color);
    }

    @Override
    public void setSize(int size) {
        r = size;
    }
}
