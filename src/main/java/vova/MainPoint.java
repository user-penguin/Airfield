package vova;

public class MainPoint implements WindowPosition, RealPosition {

    protected int DELTA = 5;

    protected double MAP_WIDTH = 10_000; // 10 000 м
    protected double MAP_HEIGHT = 5_000; // 5 000 м
    protected double WINDOW_WIDTH = 1366; // px
    protected double WINDOW_HEIGHT = 592; // px

    protected int LEFT_MAP = 32;
    protected int BOTTOM_MAP = 55;
    protected int COUNT_LEFT = 9;
    protected int COUNT_BOTTOM = 3;

    protected double x;
    protected double y;

    public MainPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public MainPoint(int x, int y) {
        this.x = (double) x/WINDOW_WIDTH * MAP_WIDTH;
        this.y = (double) y/WINDOW_HEIGHT * MAP_HEIGHT;
    }

    public String getXMap() {
        return LEFT_MAP + "°" + (int) getXReal()/MAP_WIDTH*COUNT_LEFT + "'с.ш.";
    }

    public String getYMap() {
        return BOTTOM_MAP + "°" + (int) getYReal()/MAP_HEIGHT*COUNT_BOTTOM + "'в.д.";
    }

    @Override
    public int getXPx() {
        return (int) (x/MAP_WIDTH * WINDOW_WIDTH);
    }

    @Override
    public int getYPx() {
        return (int) (y/MAP_HEIGHT * WINDOW_HEIGHT);
    }

    @Override
    public double getXReal() {
        return x;
    }

    @Override
    public double getYReal() {
        return y;
    }
}
