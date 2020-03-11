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
            throw new IllegalArgumentException("height and width must be above 0: "+
                    height+" - "+width);
        }
        this.height = height;
        this.width = width;
        shapes = new ArrayList<>();
    }

    public Drawing() {
    }

    public List<Shape> getShapes() { // uniquement pour la liste des shapes
        return new ArrayList<>(shapes);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    void addShape(Shape shape) {
        shapes.add(shape);
    }

    Shape getShapeAt(Point p) {
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

    void moveShapeAt(Point point, int dx, int dy) {
        for (Shape shape : shapes) {
            if (shape.isInside(point)) {
                shape.move(dx, dy);
            }
        }
    }

    void remove(Shape shape){
        shapes.remove(shape);
    }

    Shape getShapeByIndex(int shapeIndex) {
        return shapes.get(shapeIndex);
    }
}
