package esi.atl.g43335.asciiPaint.model;

/**
 *
 * @author g43335
 */
public abstract class ColoredShape implements Shape{
    private char color;
    
    public ColoredShape(char color){
        this.color = color;
    }
    
    @Override
    public char getColor(){
        return color;
    }
    
    @Override
    public void setColor(char color){
        this.color = color;
    }
}
