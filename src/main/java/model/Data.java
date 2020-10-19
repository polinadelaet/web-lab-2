package model;

public class Data {
    public final double x;
    public final double y;
    public final double r;
    public final String hit;

    public Data(double x, double y, double r, boolean hit) {
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
