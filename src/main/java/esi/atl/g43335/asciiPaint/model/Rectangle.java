package esi.atl.g43335.asciiPaint.model;

import java.util.Objects;

/**
 *
 * @author g43335
 */
public class Rectangle extends ColoredShape {

    private final Point upperLeft;
    private final double width;
    private final double height;

    public Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    public Point getUpperLeft() {
        return upperLeft;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.upperLeft);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.width) ^ (Double.doubleToLongBits(this.width) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32));
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
        final Rectangle other = (Rectangle) obj;
        if (Double.doubleToLongBits(this.width) != Double.doubleToLongBits(other.width)) {
            return false;
        }
        if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(other.height)) {
            return false;
        }
        if (!Objects.equals(this.upperLeft, other.upperLeft)) {
            return false;
        }
        return true;
    }

    @Override
    public void move(double dx, double dy) {
        upperLeft.move(dx, dy);
    }

    @Override
    public boolean isInside(Point p) {
        return (((p.getX() > upperLeft.getX())
                && ((p.getY() > upperLeft.getY())
                && (p.getX() <= upperLeft.getX() + width))
                && (p.getY() <= upperLeft.getY() + height)));
    }
}
