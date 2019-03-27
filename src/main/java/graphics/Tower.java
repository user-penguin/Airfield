package graphics;

import javafx.scene.control.Label;
import vova.Draw;

public class Tower implements Draw {
    private static Tower ourInstance = new Tower();

    public static Tower getInstance() {
        return ourInstance;
    }

    private Triangle triangle;

    private double x = 450;
    private double y = 360;
    private Label label;

    private Tower() {
        label = new Label("КНП");
        label.setTranslateX(x - 12);
        label.setTranslateY(y + 5);
        label.setTextFill(javafx.scene.paint.Color.color(100.0/255,171.0/255,255.0/255));

        triangle = new Triangle(x, y);
        triangle.setFill(javafx.scene.paint.Color.color(100.0/255,171.0/255,255.0/255));
    }

    @Override
    public void draw(long time) {
    }

    public Triangle getTriangle() {
        return triangle;
    }

    @Override
    public Label getLabel() {
        return label;
    }
}
