package figure;

public class Triangle extends Figure {

    public Triangle() {
        setFill(javafx.scene.paint.Color.color(150.0/255,121.0/255,1));
        getPoints().setAll(
                +0 + getTranslateX(), -5 + getTranslateY(),
                +6 + getTranslateX(), +5 + getTranslateY(),
                -6 + getTranslateX(), +5 + getTranslateY()
        );
    }

}
