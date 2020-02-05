package model;

/**
 *
 * @author g43335
 */
public interface Shape {
    void move(double dx, double dy);
    
    boolean isInside(Point p);
    
    char getColor();
}
