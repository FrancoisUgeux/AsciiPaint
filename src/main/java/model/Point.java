package model;

/**
 *
 * @author g43335
 */
public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    void move(double dx, double dy) {
        x += dx;
        y += dy;
    }
    
    double distanceTo(Point other){
        return ((this.x - other.x)+(this.y - other.y));
    }

}
