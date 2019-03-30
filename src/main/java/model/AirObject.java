package model;

import figure.Figure;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public interface AirObject {
    Label getLabel();
    Figure getFigure();
    void draw(long time, AnchorPane root);
}
