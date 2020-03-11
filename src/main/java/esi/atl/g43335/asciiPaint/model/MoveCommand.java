package esi.atl.g43335.asciiPaint.model;

/**
 *
 * @author franc
 */
public class MoveCommand implements Commands{
    Shape shape; // private 
    int dx;
    int dy;

    public MoveCommand(Shape shape, int dx, int dy) {
        this.shape = shape;
        this.dx = dx;
        this.dy = dy;
    }
    
    @Override
    public void execute() {
        shape.move(dx, dy);
    }

    @Override
    public void unexecute() {
        shape.move(-dx, -dy);
    }
}
