package esi.atl.g43335.asciiPaint.model;

/**
 *
 * @author g43335
 */
public class Rectangle extends ColoredShape {

    private Point upperLeft;
    private double width;
    private double height;

    public Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    public Point getUpperLeft() {
        return upperLeft;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void move(double dx, double dy) {
        upperLeft.move(dx, dy);
    }

    @Override
    public boolean isInside(Point p) {
        return (((p.getX() > upperLeft.getX())
                && ((p.getY() > upperLeft.getY())
                && (p.getX() <= upperLeft.getX() + width))
                && (p.getY() <= upperLeft.getY() + height)));
    }
}
