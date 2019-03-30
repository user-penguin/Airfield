package model;

import figure.Figure;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.util.Date;

public abstract class BaseAirObject implements AirObject {

    protected Label label = new Label();
    protected Figure figure;
    protected Point point;

    protected double dx;
    protected double dy;
    protected double speed;
    protected Date lastTime;

    public BaseAirObject(Figure figure, Point point) {
        this.figure = figure;
        this.point = point;
    }

    @Override
    public Label getLabel() {
        return label;
    }

    @Override
    public Figure getFigure() {
        return figure;
    }

    @Override
    public abstract void draw(long time, AnchorPane root);
}
