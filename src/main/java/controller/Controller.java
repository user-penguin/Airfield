package controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import route.Route;

import javax.swing.text.html.ImageView;

public class Controller {
    private Route route;
    private boolean isRecording;

    @FXML
    private Pane dromePain;


    @FXML
    private void initialize () {
        route = new Route();
        isRecording = false;
        dromePain.addEventHandler(MouseEvent.MOUSE_CLICKED, e-> {
            if (isRecording) {
                System.out.println(e.getX());
                System.out.println(e.getY());
            }
        });
    }

    @FXML
    public void recordRun () {
        isRecording = true;
    }

    @FXML
    public void recordStop () {
        isRecording = false;
    }
}
