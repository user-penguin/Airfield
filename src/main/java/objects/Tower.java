package objects;

import figure.Triangle;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import vova.DrawNodeLabel;
import vova.Point;

public class Tower extends DrawNodeLabel {

    private static Tower ourInstance = new Tower();

    public static Tower getInstance() {
        return ourInstance;
    }

    private Color color = Color.color(100.0/255,171.0/255,255.0/255);

    private Point point = new Point(450, 360);

    private Tower() {
        super();
        Label label = new Label();
        label.setText("КНП");
        label.setTranslateX(point.getXPx() - 12);
        label.setTranslateY(point.getYPx() + 5);
        label.setTextFill(color);
        this.label = label;

        Triangle triangle = new Triangle();
        triangle.setTranslateX(point.getXPx());
        triangle.setTranslateY(point.getXPx());
        triangle.setFill(color);
        figure = triangle;
    }
}
