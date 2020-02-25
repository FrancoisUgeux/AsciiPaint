package esi.atl.g43335.asciiPaint.model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author g43335
 */
public class Drawing {

    private List<Shape> shapes;
    private int height;
    private int width;

    public Drawing(int height, int width) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("height and width must be above 0");
        }
        this.height = height;
        this.width = width;
        shapes = new ArrayList<>();
    }

    public Drawing() {
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public Shape getShapeAt(Point p) {
        Shape shape = null;
        for (Shape sh : this.shapes) {
            if (sh.isInside(p)) {
                shape = sh;
                break;
            }
        }
        return shape;
    }

    public char getColoredShape(Point point) {
        for (Shape shape : shapes) {
            if (shape.isInside(point)) {
                return shape.getColor();
            }
        }
        return ' ';
    }

    public void moveShapeAt(Point point, int dx, int dy) {
        for (Shape shape : shapes) {
            if (shape.isInside(point)) {
                shape.move(dx, dy);
            }
        }
    }

    public void removeShapeAt(Point point) {
        for (Shape shape : shapes) {
            if (shape.isInside(point)) {
                shapes.remove(shape);
            }
        }
    }
    
    void remove(Shape shape){
        shapes.remove(shape);
    }

    public Shape getShapeByIndex(int shapeIndex) {
        return shapes.get(shapeIndex);
    }
}
