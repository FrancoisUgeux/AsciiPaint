package esi.atl.g43335.asciiPaint.model;

import java.util.Objects;

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

    Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.center);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.radius) ^ (Double.doubleToLongBits(this.radius) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Circle other = (Circle) obj;
        if (Double.doubleToLongBits(this.radius) != Double.doubleToLongBits(other.radius)) {
            return false;
        }
        if (!Objects.equals(this.center, other.center)) {
            return false;
        }
        return true;
    }

    
    @Override
    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    @Override
    public boolean isInside(Point p) {
        return center.distanceTo(p) <= radius;
    }
}
