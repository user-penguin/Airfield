package route;

import model.Point;

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
                writer.write(point.getPxX() + " " + point.getPxY() + " " + point.getRealZ() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Route readRoute (String filename) {
        // маршруты лежат в папке way
        String pathToSource = "src/main/resources/way/" + filename + ".txt";
        Route route = new Route();
        try {
            FileInputStream fstream = new FileInputStream(new File(pathToSource));
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

    public static Route readRouteWithSpeed (String filename) {
        // маршруты лежат в папке way
        String pathToSource = "src/main/resources/way/" + filename + ".txt";
        Route route = new Route();
        try {
            FileInputStream fstream = new FileInputStream(new File(pathToSource));
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String read;
            while((read = br.readLine()) != null) {
                String[] xyFromFile = read.split(" ");
                int xCoordinate = Integer.parseInt(xyFromFile[0]);
                int yCoordinate = Integer.parseInt(xyFromFile[1]);
                double zCoordinate = Double.parseDouble(xyFromFile[2]);
                double speed = Double.parseDouble(xyFromFile[3]);
                Point point = new Point(xCoordinate, yCoordinate, zCoordinate, speed);
                route.addCoordinate(point);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return route;
    }

    public static int readSpeed (String fiename) {
        // скорости лежат в папке speed
        String pathToSpeed = "src/main/resources/speed/" + fiename + ".txt";
        int speed = 0;
        try {
            FileInputStream fstream = new FileInputStream(new File(pathToSpeed));
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String read = br.readLine();
            speed = Integer.parseInt(read);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return speed;
    }
}
