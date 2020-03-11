package esi.atl.g43335.asciiPaint.model;

/**
 *
 * @author franc
 */
public class RemoveCommand implements Commands{
    Drawing drawing;
    Shape shape; // priuvate 

    public RemoveCommand(Drawing drawing, Shape shape) {
        this.drawing = drawing;
        this.shape = shape;
    }
    
    @Override
    public void execute() {
        drawing.remove(shape);
    }

    @Override
    public void unexecute() {
        drawing.addShape(shape);
    }
    
    
}
