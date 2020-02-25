package esi.atl.g43335.asciiPaint.model;

import java.lang.Math;
import java.util.Objects;

/**
 *
 * @author franc
 */
public class Line extends ColoredShape {

    private Point p1;
    private Point p2;

    public Line(Point point1, Point point2, char color) {
        super(color);
        this.p1 = point1;
        this.p2 = point2;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.p1);
        hash = 97 * hash + Objects.hashCode(this.p2);
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
        final Line other = (Line) obj;
        if (!Objects.equals(this.p1, other.p1)) {
            return false;
        }
        if (!Objects.equals(this.p2, other.p2)) {
            return false;
        }
        return true;
    }

    @Override
    public void move(double dx, double dy) {
        p1.move(dx, dy);
    }

    @Override
    public boolean isInside(Point p) {
        return ((((p1.getY() - p2.getY()) * p.getX() + (p2.getX() - p1.getX())
                * p.getY() + p1.getX() * p2.getY() - p2.getX() * p1.getY())
                / (Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2))
                + Math.pow((p2.getY() - p1.getY()), 2))) == 0);
    }

}
