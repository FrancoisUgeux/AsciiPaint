package esi.atl.g43335.asciiPaint.model;

/**
 *
 * @author franc
 */
public class ColorCommand implements Commands{

    Shape shape;
    char color;
    char save;

    public ColorCommand(Shape shape,char color) {
        this.color = color;
        this.shape = shape;
        this.save = shape.getColor();
    }

    @Override
    public void execute() {
        shape.setColor(color);
    }

    @Override
    public void unexecute() {
        shape.setColor(save);
    }

}
