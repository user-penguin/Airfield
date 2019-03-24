package vova;

import javafx.scene.Node;
import javafx.scene.control.Label;

public interface Draw {
    void draw(long time);

    Label getLabel();

    Node getTriangle();
}
