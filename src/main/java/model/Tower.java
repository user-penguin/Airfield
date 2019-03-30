package model;

import figure.Triangle;
import javafx.scene.paint.Color;

public class Tower extends BaseAirObject {
    private static Tower ourInstance = new Tower();

    public static Tower getInstance() {
        return ourInstance;
    }

    private Tower() {
        super(new Triangle(), new Point(466, 495));
        label.setText("КНП");
        Color color = Color.color(150.0/255,120.0/255,255.0/255);
        figure.setFillColor(color);
        label.setTextFill(color);
    }

    @Override
    public void draw(long time) {
        figure.setPosition(point.getPxX(), point.getPxY());
        label.setTranslateX(point.getPxX() - 12);
        label.setTranslateY(point.getPxY() + 7);
    }
}
