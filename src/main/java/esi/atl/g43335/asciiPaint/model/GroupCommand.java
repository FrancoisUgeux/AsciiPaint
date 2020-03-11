package esi.atl.g43335.asciiPaint.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author franc
 */
public class GroupCommand implements Commands {

    private Drawing drawing;
    private Shape shape1;
    private Shape shape2;
    private Group group;

    public GroupCommand(Drawing drawing, Shape shape1, Shape shape2, char color) {
        this.drawing = drawing;
        this.shape1 = shape1;
        this.shape2 = shape2;
        List<Shape> shapes = new ArrayList<>();
        shapes.add(shape1);
        shapes.add(shape2);
        this.group = new Group(shapes, color);
    }

    @Override
    public void execute() {
        drawing.addShape(group);
        drawing.remove(shape1);
        drawing.remove(shape2);
    }

    @Override
    public void unexecute() {
        drawing.remove(group);
        drawing.addShape(shape1);
        drawing.addShape(shape2);
    }
}
