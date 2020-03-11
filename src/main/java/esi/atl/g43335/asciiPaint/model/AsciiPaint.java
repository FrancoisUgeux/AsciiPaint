package esi.atl.g43335.asciiPaint.model;

import esi.atl.g43335.asciiPaint.controller.Application;
import esi.atl.g43335.asciiPaint.model.*;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author g43335
 */
public class AsciiPaint {

    private Drawing drawing;
    private int speed = 0; // vue ou controlleur
    private Stack<Commands> undoStack;
    private Stack<Commands> redoStack;

    public AsciiPaint(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("width and height must be above 0");
        }
        this.drawing = new Drawing(width, height);
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public AsciiPaint() {
        this.drawing = new Drawing();
        // tu n'initialise pas les stack ?
    }

    public Drawing getDrawing() {
        return drawing;
    }

    public void newCircle(int x, int y, double radius, char color) {
        Commands add = new AddCommand(drawing, new Circle(new Point(x, y), radius, color));
        add.execute();
        undoStack.push(add);
        redoStack.clear();
    }

    public void newRectangle(int x, int y, double width, double height, char color) {
        Commands add = new AddCommand(drawing, new Rectangle(new Point(x, y), width, height, color));
        add.execute();
        undoStack.push(add);
        redoStack.clear();
    }

    public void newSquare(int x, int y, double side, char color) {
        Commands add = new AddCommand(drawing, new Square(new Point(x, y), side, color));
        add.execute();
        undoStack.push(add);
        redoStack.clear();
    }

    public void newLine(int x1, int y1, int x2, int y2, char color) {
        Commands add = new AddCommand(drawing, new Line(new Point(x1, x2), new Point(x2, y2), color));
        add.execute();
        undoStack.push(add);
        redoStack.clear();
    }

    public int getWidth() {
        return drawing.getWidth();
    }

    public int getHeight() {
        return drawing.getHeight();
    }

    public int getSpeed() { // controlleur 
        return speed;
    }

    public String getColor(int x, int y) { // vue
        //return drawing.getColoredShape(new Point(x, y));
        Point p = new Point(x, y);
            switch (drawing.getColoredShape(p)) {
            case 'r':
                return "\u001B[41m";//red
            case 'g':
                return "\u001B[42m";//green
            case 'b':
                return "\u001B[44m";//blue
            case 'y':
                return "\u001B[43m";//yellow
            case 'p':
                return "\u001B[45m";//purple
            case 'c':
                return "\u001B[46m";//cyan
            default:
                return "\u001B[40m";//black
        }
    }

    public void moveShape(int index, int dx, int dy) {
        Shape shape = drawing.getShapeByIndex(index);
        Commands move = new MoveCommand(shape, dx, dy);
        move.execute();
        undoStack.push(move);
        redoStack.clear();
    }


    public void removeShape(int shapeIndex) {
        Commands remove = new RemoveCommand(drawing, drawing.getShapeByIndex(shapeIndex));
        remove.execute();
        undoStack.push(remove);
        redoStack.clear();
    }

    public void newGroup(int shapeIndex1, int shapeIndex2) {
        Shape shape1 = drawing.getShapeByIndex(shapeIndex1);
        Shape shape2 = drawing.getShapeByIndex(shapeIndex2);
        Commands group = new GroupCommand(drawing, shape1, shape2, shape1.getColor());
        group.execute();
        undoStack.push(group);
        redoStack.clear();
    }

    public void changeColor(int shapeIndex, char color) {
        Shape shape = drawing.getShapeByIndex(shapeIndex);
        Commands colors = new ColorCommand(shape, color);
        colors.execute();
        undoStack.push(colors);
        redoStack.clear();
    }

   // public void setSpeed(String string) { // controlleur
   //     this.speed = Integer.parseInt(string);
   // }

    public void pause() { // controlleur, private
        try {
            Thread.sleep(speed);
        } catch (InterruptedException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void undo() {
        redoStack.push(undoStack.peek());
        undoStack.pop().unexecute();
    }

    public void redo() {
        redoStack.pop().execute();
        // undo.push
    }
}
