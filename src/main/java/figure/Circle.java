package figure;

import javafx.scene.paint.Color;

public class Circle extends javafx.scene.shape.Circle implements Figure {

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

}
