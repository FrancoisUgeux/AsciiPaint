package esi.atl.g43335.asciiPaint.model;

/**
 *
 * @author franc
 */
public class ColorCommand implements Commands{

    private Shape shape;
    private char newColor;
    private char oldColor;

    public ColorCommand(Shape shape,char color) {
        this.newColor = color;
        this.shape = shape;
        this.oldColor = shape.getColor();
    }

    @Override
    public void execute() {
        shape.setColor(newColor);
    }

    @Override
    public void unexecute() {
        shape.setColor(oldColor);
    }

}
