package vova;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.AirObject;
import model.Factory;
import route.Route;
import tool.RouteHandler;

import java.util.LinkedList;
import java.util.List;

public class Main extends Application {

    private AnchorPane root;
    private List<AirObject> airObjects = new LinkedList<>();

    private boolean work = true;

    private AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            for (AirObject draw: airObjects) {
                if (work) {
                    draw.draw(now, root);
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
        animationTimer.start();

        add(Factory.createTower());
        Route route1 = RouteHandler.readRoute("car1");
        Route route2 = RouteHandler.readRoute("car2");
        Route route3 = RouteHandler.readRoute("car3");
        add(Factory.createCar(route1, 0.5));
        add(Factory.createCar(route2, 0.5));
        add(Factory.createCar(route3, 0.5));

        Route routePlane = RouteHandler.readRoute("plane1");
        add(Factory.createPlane(routePlane, 10));

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void add(AirObject airObject) {
        airObjects.add(airObject);
        root.getChildren().add(airObject.getLabel());
        root.getChildren().add((Node) airObject.getFigure());
    }
}
