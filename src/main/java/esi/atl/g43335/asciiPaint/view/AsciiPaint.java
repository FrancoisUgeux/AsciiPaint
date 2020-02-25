package esi.atl.g43335.asciiPaint.view;

import esi.atl.g43335.asciiPaint.controller.Application;
import esi.atl.g43335.asciiPaint.model.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author g43335
 */
public class AsciiPaint {

    private Drawing drawing;
    private View view;
    private int speed = 0;
    private Stack<Commands> undoStack;
    private Stack<Commands> redoStack;
    

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

    public int getSpeed() {
        return speed;
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

    public void changeColor(int shapeIndex, char color) {
        drawing.getShapeByIndex(shapeIndex).setColor(color);
    }

    public void loadFile(String file) {
        try {
            InputStream in = new FileInputStream(file);
            view.setInput(in);
        } catch (FileNotFoundException ex) {
            System.err.println("File not found" + file);
        }
    }

    public void setSpeed(String string) {
        this.speed = Integer.parseInt(string);
    }

    public void pause() {
        try {
            Thread.sleep(speed);
        } catch (InterruptedException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
