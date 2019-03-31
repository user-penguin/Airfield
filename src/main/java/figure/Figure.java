package figure;

import javafx.scene.paint.Color;

public interface Figure {
    void setPosition(int pxX, int pxY);

    void setFillColor(Color color);

    void setSize(int size);
}
