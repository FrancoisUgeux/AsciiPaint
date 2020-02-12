package esi.atl.g43335.asciiPaint.view;

import esi.atl.g43335.asciiPaint.model.Circle;
import esi.atl.g43335.asciiPaint.model.Drawing;
import esi.atl.g43335.asciiPaint.model.Point;
import esi.atl.g43335.asciiPaint.model.Rectangle;
import esi.atl.g43335.asciiPaint.model.Shape;
import esi.atl.g43335.asciiPaint.model.Square;

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

    int getWidth() {
        return drawing.getWidth();
    }

    int getHeight() {
        return drawing.getHeight();
    }

    char getColor(int x, int y) {
        return drawing.getColoredShape(new Point(x,y));
    }
}