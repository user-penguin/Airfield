package vova;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import objects.Tower;

import java.util.LinkedList;
import java.util.List;

public class Main extends Application {

    private AnchorPane root;
    private List<Draw> draws = new LinkedList<>();

    private boolean work = true;

    private AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            for (Draw draw: draws) {
                if (work) {
                    draw.draw(now);
                }
            }
        }
    };

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/FXML/vova.fxml"));
        primaryStage.setTitle("Аirfield");
        primaryStage.setScene(new Scene(root, 1366, 592));
        Button startPause = new Button("Старт/Пауза");
        startPause.setTranslateX(1250);
        startPause.setTranslateY(550);
        startPause.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> work = !work);
        root.getChildren().add(startPause);
        primaryStage.show();



        add(Tower.getInstance());

        animationTimer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void add(Draw draw) {
        draws.add(draw);
        root.getChildren().add(draw.getLabel());
        root.getChildren().add(draw.getFigure());
    }
}
