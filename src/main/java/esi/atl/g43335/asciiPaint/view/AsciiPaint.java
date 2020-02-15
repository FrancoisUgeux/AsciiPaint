package esi.atl.g43335.asciiPaint.view;

import esi.atl.g43335.asciiPaint.model.Circle;
import esi.atl.g43335.asciiPaint.model.Drawing;
import esi.atl.g43335.asciiPaint.model.Group;
import esi.atl.g43335.asciiPaint.model.Line;
import esi.atl.g43335.asciiPaint.model.Point;
import esi.atl.g43335.asciiPaint.model.Rectangle;
import esi.atl.g43335.asciiPaint.model.Shape;
import esi.atl.g43335.asciiPaint.model.Square;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g43335
 */
public class AsciiPaint {

    private Drawing drawing;

    public AsciiPaint(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("width and height must be above 0");
        }
        this.drawing = new Drawing(width, height);
    }

    public AsciiPaint() {
        this.drawing = new Drawing();
    }

    public Drawing getDrawing() {
        return drawing;
    }

    public void newCircle(int x, int y, double radius, char color) {
        Shape shape = new Circle(new Point(x, y), radius, color);
        drawing.addShape(shape);
    }

    public void newRectangle(int x, int y, double width, double height, char color) {
        Shape shape = new Rectangle(new Point(x, y), width, height, color);
        drawing.addShape(shape);
    }

    public void newSquare(int x, int y, double side, char color) {
        Shape shape = new Square(new Point(x, y), side, color);
        drawing.addShape(shape);
    }

    public void newLine(int x1, int y1, int x2, int y2, char color) {
        Shape shape = new Line(new Point(x1, x2), new Point(x2, y2), color);
        drawing.addShape(shape);
    }

    int getWidth() {
        return drawing.getWidth();
    }

    int getHeight() {
        return drawing.getHeight();
    }

    char getColor(int x, int y) {
        return drawing.getColoredShape(new Point(x, y));
    }

    public void moveShapeAt(int x, int y, int dx, int dy) {
        drawing.moveShapeAt(new Point(x, y), dx, dy);
    }

    public void removeShapeAt(int x, int y) {
        drawing.removeShapeAt(new Point(x, y));
    }

    public void removeShape(int shape) {
        drawing.getShapes().remove(shape);
    }

    public void newGroup(int shapeIndex1, int shapeIndex2) {
        List<Shape> shapes = new ArrayList<>();
        Shape shape1 = drawing.getShapeByIndex(shapeIndex1);
        Shape shape2 = drawing.getShapeByIndex(shapeIndex2);
        shapes.add(shape1);
        shapes.add(shape2);
        Group group = new Group(shapes, shape1.getColor());
        drawing.addShape(group);
        drawing.getShapes().remove(shape1);
        drawing.getShapes().remove(shape2);
    }
}
