package esi.atl.g43335.asciiPaint.model;

/**
 *
 * @author g43335
 */
public class Circle extends ColoredShape {

    private Point center;
    private double radius;

    public Circle(Point center, double radius,char color) {
        super(color);
        if (radius <= 0) {
            throw new IllegalArgumentException("radius must be positive"
                    + ", received: " + radius);
        }
        if(color == ' '){
            throw new IllegalArgumentException("color can't be empty");
        }
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    @Override
    public boolean isInside(Point p) {
        double distance = center.distanceTo(p);
        return distance <= radius;
    }
}
