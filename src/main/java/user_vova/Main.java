package user_vova;

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
import model.Plane;
import route.Route;
import route.RouteHandler;

import java.util.LinkedList;
import java.util.List;

public class Main extends Application {

    private AnchorPane root;
    private List<AirObject> airObjects = new LinkedList<>();

    private boolean work = true;
    private AirObject plane1;
    private AirObject plane2;
    private AirObject car;
    boolean f1 = false;
    boolean f2 = false;

    private AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            for (AirObject draw: airObjects) {
                if (work) {
                    draw.draw(now, root);
                }
                if (!f1 && ((Plane) plane1).getPoint().length(((Plane) plane2).getPoint()) < 500) {
                    plane1.danger();
                    plane2.danger();
                    audioDanger();
                    f1 = true;
                    System.out.println("Опасно " + ((Plane) plane1).getPoint().length(((Plane) plane2).getPoint()));
                } else if (f1 && !f2 && ((Plane) plane1).getPoint().length(((Plane) plane2).getPoint()) > 600) {
                    plane1.notDanger();
                    plane2.notDanger();
                    audioNotDanger();
                    f2 = true;
                    System.out.println("Не опасно " + ((Plane) plane1).getPoint().length(((Plane) plane2).getPoint()));
                }
            }
        }
    };

    private void audioNotDanger() {

    }

    private void audioDanger() {

    }

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
        car = Factory.createCar(route1, 0.5);
        add(car);
        add(Factory.createCar(route2, 0.5));
        add(Factory.createCar(route3, 0.5));

        Route routePlane = RouteHandler.readRouteWithSpeed("plane1");
        plane1 = Factory.createPlane(routePlane);
        add(plane1);
        Route routePlane2 = RouteHandler.readRouteWithSpeed("plane2");
        plane2 = Factory.createPlane(routePlane2);
        add(plane2);
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
