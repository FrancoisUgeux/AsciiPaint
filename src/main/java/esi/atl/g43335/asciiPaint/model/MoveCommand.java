package esi.atl.g43335.asciiPaint.model;

/**
 *
 * @author franc
 */
public class MoveCommand implements Commands{
    Shape shape;
    int x;
    int y;

    public MoveCommand(Shape shape, int dx, int dy) {
        this.shape = shape;
        this.x = dx;
        this.y = dy;
    }
    
    @Override
    public void execute() {
        shape.move(x, y);
    }

    @Override
    public void unexecute() {
        shape.move(-x, -y);
    }
}
