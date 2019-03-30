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
    protected double dz;
    protected double speed;
    protected Date lastTime;
    protected Date lastTime1;

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
