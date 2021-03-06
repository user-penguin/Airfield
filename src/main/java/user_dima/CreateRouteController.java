package user_dima;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.Point;
import route.Route;
import route.RouteHandler;

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
    private TextField inputFileName, height;

    @FXML
    private void initialize () {
        route = new Route();
        isRecording = false;
        dromePain.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e) {
                if (isRecording) {
                    int xCoordinate = (int) e.getX();
                    System.out.println(e.getX());
                    int yCoordinate = (int) e.getY();
                    System.out.println(e.getY());
                    route.addCoordinate(new Point(xCoordinate, yCoordinate, Double.parseDouble(height.getText()), 0));
                }
            }
        });

        dromePain.setOnScroll(new EventHandler<ScrollEvent>() {
            public void handle(ScrollEvent event) {
                // Adjust the zoom factor as per your requirement
                int zoomFactor = 50;
                int oldHeight = Integer.parseInt(height.getText());
                double deltaY = event.getDeltaY();
                if (deltaY > 0) {
                    int newHeight = oldHeight + zoomFactor;
                    height.setText(String.valueOf(newHeight));
                } else {
                    int newHeight = oldHeight - zoomFactor;
                    height.setText(String.valueOf(newHeight));
                }
            }
        });
        URL helicopterPath = getClass().getResource("/sound/helicopter.mp3");
        Media helicopter = new Media(helicopterPath.toString());
        mediaPlayer = new MediaPlayer(helicopter);
        height.setText("0");
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
