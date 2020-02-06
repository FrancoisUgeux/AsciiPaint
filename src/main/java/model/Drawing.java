package model;

import java.util.List;

/**
 *
 * @author g43335
 */
public class Drawing {
    private List<Shape>shapes;
    private int height;
    private int width;

    public Drawing(int height, int width) {
        this.height = height;
        this.width = width;
    }
    
    public Drawing(){
        
    }
    
    public void addShape(Shape shape){
        
    }
    
    public Shape getShapeAt(Point p){
        
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getWidth(){
        return width;
    }
}
