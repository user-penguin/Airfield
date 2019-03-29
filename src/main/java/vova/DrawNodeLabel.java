package vova;

import figure.Figure;
import javafx.scene.control.Label;

public abstract class DrawNodeLabel implements Draw {

    protected Label label;
    protected Figure figure;

    @Override
    public Label getLabel() {
        return label;
    }

    @Override
    public Figure getFigure() {
        return figure;
    }

    @Override
    public void draw(long time) {

    }
}
