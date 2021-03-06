package user_vova;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import model.AirObject;
import model.Factory;
import model.Plane;
import route.Route;
import route.RouteHandler;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class Main1 extends Application {

    private AnchorPane root;
    private List<AirObject> airObjects = new LinkedList<AirObject>();
    private MediaPlayer startAudioPlayer;
    private MediaPlayer dangerPlayer;

    private boolean work = false;
    private AirObject plane1;
    private AirObject plane2;
    boolean p1 = false;
    boolean pd1 = false;
    boolean start = true;

    private AnimationTimer animationTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            for (AirObject draw: airObjects) {
                if (work) {
                    draw.draw(now, root);
                    if (start) {
                        startAudio();
                        start = false;
                    }
                    if (!p1 && ((Plane) plane1).getPoint().length(((Plane) plane2).getPoint()) < 500) {
                        plane1.danger();
                        plane2.danger();
                        audioDanger();
                        p1 = true;
                        System.out.println("Опасно " + ((Plane) plane1).getPoint().length(((Plane) plane2).getPoint()));
                    } else if (p1 && !pd1 && ((Plane) plane1).getPoint().length(((Plane) plane2).getPoint()) > 600) {
                        plane1.notDanger();
                        plane2.notDanger();
                        audioNotDanger();
                        pd1 = true;
                        System.out.println("Не опасно " + ((Plane) plane1).getPoint().length(((Plane) plane2).getPoint()));
                    }
                }
            }
        }
    };

    private void startAudio() {
        startAudioPlayer.play();
    }

    private void audioNotDanger() {
        dangerPlayer.stop();
    }

    private void audioDanger() {
        dangerPlayer.play();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // инициализация разговора
        URL audioPath = getClass().getResource("/sound/final_sc1.wav");
        Media audio = new Media(audioPath.toString());
        startAudioPlayer = new MediaPlayer(audio);
        // инициализация тревоги
        URL dangerAudioPath = getClass().getResource("/sound/scene1danger.mp3");
        final Media danger = new Media(dangerAudioPath.toString());
        dangerPlayer = new MediaPlayer(danger);

        root = FXMLLoader.load(getClass().getResource("/FXML/vova.fxml"));
        primaryStage.setTitle("Аirfield");
        primaryStage.setScene(new Scene(root, 1366, 592));
        Polygon polygon = new Polygon();
        polygon.getPoints().setAll(
                0.0 , 0.0,
                2300.0, 0.0,
                2300.0, 1500.0,
                0.0, 1500.0
        );
        polygon.setFill(Color.BLACK);
        root.getChildren().add(0, polygon);
        Button startPause = new Button("Старт/Пауза");
        startPause.setTranslateX(10);
        startPause.setTranslateY(10);
        startPause.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                work = !work;
                if (!work) {
                    startAudioPlayer.pause();
                } else {
                    startAudioPlayer.play();
                }
            }
        });
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

        Route routePlane = RouteHandler.readRouteWithSpeed("plane1");
        plane1 = Factory.createPlane(routePlane, "KM251");
        add(plane1);
        Route routePlane2 = RouteHandler.readRouteWithSpeed("plane2");
        plane2 = Factory.createPlane(routePlane2, "SP901");
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
