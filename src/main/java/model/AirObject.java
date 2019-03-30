package model;

import figure.Figure;
import javafx.scene.control.Label;

public interface AirObject {
    Label getLabel();
    Figure getFigure();
    void draw(long time);
}
