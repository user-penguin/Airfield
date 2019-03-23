package vova;

import graphics.Point;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
        primaryStage.setScene(new Scene(root, 1366, 600));
        primaryStage.show();

        RouteHandler routeHandler = new RouteHandler();
        Route route = routeHandler.readRoute("VovaTestiruj");
        System.out.println(route.getAllCoordinates());
        Point point = new Point(1, route, "Точка тест");
        add(point);

        animationTimer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void add(Draw draw) {
        draws.add(draw);
        root.getChildren().add((Node) draw);
        root.getChildren().add(draw.getLabel());
    }
}
