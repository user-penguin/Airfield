package figure;

import javafx.scene.paint.Color;

public class Circle extends javafx.scene.shape.Circle implements Figure {

    double r = 3;

    public Circle() {
        super(3);
    }

    @Override
    public void setPosition(int pxX, int pxY) {
        setCenterX(pxX);
        setCenterY(pxY);
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
