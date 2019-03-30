package tool;

import model.Point;
import route.Route;

import java.io.*;

public class RouteHandler {
    public void writeRoute (Route route, String filename) {
        // маршруты лежат в папке way
        String filePath = "/way";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream
                    (getClass().getResource(filePath).getPath() + "/" + filename + ".txt");
            Writer writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            for (Point point: route.getAllCoordinates()) {
                writer.write(point.getPxX() + " " + point.getPxY() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Route readRoute (String filename) {
        // маршруты лежат в папке way
        String pathToSource = "/way/" + filename + ".txt";
        Route route = new Route();
        try {
            FileInputStream fstream = new FileInputStream(RouteHandler.class.getResource(pathToSource).getPath());
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String read;
            while((read = br.readLine()) != null) {
                String[] xyFromFile = read.split(" ");
                int xCoordinate = Integer.parseInt(xyFromFile[0]);
                int yCoordinate = Integer.parseInt(xyFromFile[1]);
                Point point = new Point(xCoordinate, yCoordinate);
                route.addCoordinate(point);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return route;
    }
}
