package esi.atl.g43335.asciiPaint.model;

/**
 *
 * @author franc
 */
public class AddCommand implements Commands {

    private Drawing drawing;
    private Shape shape;

    public AddCommand(Drawing drawing, Shape shape) {
        this.drawing = drawing;
        this.shape = shape;
    }

    @Override
    public void execute() {
        drawing.addShape(shape);
    }

    @Override
    public void unexecute() {
        drawing.remove(shape);
    }
}
