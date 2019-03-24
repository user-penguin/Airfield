package vova;

import graphics.Point;
import graphics.TypeAuto;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import route.Route;
import tool.RouteHandler;

import java.util.LinkedList;
import java.util.List;

public class Main extends Application {

    private AnchorPane root;
    private List<Draw> draws = new LinkedList<>();

    private AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            for (Draw draw: draws) {
                draw.draw(now);
            }
        }
    };

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/FXML/vova.fxml"));
        primaryStage.setTitle("Аirfield");
        primaryStage.setScene(new Scene(root, 1366, 590));
        primaryStage.show();

        RouteHandler routeHandler = new RouteHandler();

        Route car1Poute = routeHandler.readRoute("car1");
        Point car1 = new Point(0.5, car1Poute, TypeAuto.ADS, "А137МР", root);
        add(car1);

        Route car2Poute = routeHandler.readRoute("car2");
        Point car2 = new Point(0.2, car2Poute,  TypeAuto.MLAD, "К710ОМ", root);
        add(car2);

        Route car3Poute = routeHandler.readRoute("car3");
        Point car3 = new Point(0.95, car3Poute, TypeAuto.MLAD, "У613ТР", root);
        add(car3);

        animationTimer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void add(Draw draw) {
        draws.add(draw);
        root.getChildren().add(draw.getLabel());
    }
}
