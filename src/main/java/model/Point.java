package model;

public class Point {
    private final double x;
    private final double y;
    private final double r;
    private final String hit;

    public Point(double x, double y, double r, boolean hit) {
        this.x = x;
        this.y = y;
        this.r = r;
        if (hit) {
            this.hit = "Попадание";
        } else this.hit = "Непопадание";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public String getHit() {
        return hit;
    }
}
