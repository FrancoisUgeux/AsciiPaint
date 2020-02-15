package esi.atl.g43335.asciiPaint.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class Group extends ColoredShape {

    List<Shape> shapes = new ArrayList<>();

    public Group(List<Shape> shapes, char color) {
        super(color);
        this.shapes = shapes;
    }

    @Override
    public boolean isInside(Point p) {
        for (Shape shape : shapes) {
            if (shape.isInside(p)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void move(double dx, double dy) {
        for (Shape shape : shapes) {
            shape.move(dx, dy);
        }
    }
}
