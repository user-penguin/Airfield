package dima;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.Point;
import route.Route;
import tool.RouteHandler;

import java.net.URL;

public class CreateRouteController {
    private Route route;
    private boolean isRecording;
    private String filename;

    @FXML
    private Pane dromePain;

    @FXML
    private MediaPlayer mediaPlayer;

    @FXML
    private TextField inputFileName;

    @FXML
    private void initialize () {
        route = new Route();
        isRecording = false;
        dromePain.addEventHandler(MouseEvent.MOUSE_CLICKED, e-> {
            if (isRecording) {
                int xCoordinate = (int) e.getX();
                System.out.println(e.getX());
                int yCoordinate = (int) e.getY();
                System.out.println(e.getY());
                route.addCoordinate(new Point(xCoordinate, yCoordinate));
            }
        });
        URL helicopterPath = getClass().getResource("/sound/helicopter.mp3");
        Media helicopter = new Media(helicopterPath.toString());
        mediaPlayer = new MediaPlayer(helicopter);
    }

    @FXML
    public void recordRun () {
        isRecording = true;
        route = new Route();
        this.filename = inputFileName.getText();

    }
    @FXML
    public void recordStop () {
        RouteHandler routeHandler = new RouteHandler();
        routeHandler.writeRoute(this.route, this.filename);
        isRecording = false;
    }

    @FXML
    public void startHelicopter() {
        mediaPlayer.play();
    }

    @FXML
    public void pauseHelicopter() {
        mediaPlayer.pause();
    }

    @FXML
    public void stopHelicopter() {
        mediaPlayer.stop();
    }
}
