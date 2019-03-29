package dima;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import route.Route;
import tool.RouteHandler;
import vova.Point;

public class CreateRouteController {
    private Route route;
    private boolean isRecording;
    private String filename;

    @FXML
    private Pane dromePain;

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
}
