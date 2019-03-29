package vova;

import figure.Figure;
import javafx.scene.control.Label;

public interface Draw {
    void draw(long time);
    Label getLabel();
    Figure getFigure();
}
