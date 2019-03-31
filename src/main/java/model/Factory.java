package model;

import route.Route;

public class Factory {
    public static BaseAirObject createTower() {
        return Tower.getInstance();
    }

    public static AirObject createCar(Route route, double speed) {
        return new Car(route, speed);
    }

    public static AirObject createPlane(Route route, String name) {
        return new Plane(route, name);
    }
}
