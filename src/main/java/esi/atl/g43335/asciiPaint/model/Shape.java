package esi.atl.g43335.asciiPaint.model;

/**
 *
 * @author g43335
 */
public interface Shape {
    
    /**
     * JAVADOC DANS LES INTERFACES
     * @param dx
     * @param dy 
     */
    void move(double dx, double dy);
    
    boolean isInside(Point p);
    
    char getColor();

    public void setColor(char color);
}
