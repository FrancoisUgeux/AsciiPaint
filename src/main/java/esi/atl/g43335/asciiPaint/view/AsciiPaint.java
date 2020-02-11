package esi.atl.g43335.asciiPaint.view;

import esi.atl.g43335.asciiPaint.model.Circle;
import esi.atl.g43335.asciiPaint.model.Drawing;
import esi.atl.g43335.asciiPaint.model.Point;
import esi.atl.g43335.asciiPaint.model.Rectangle;
import esi.atl.g43335.asciiPaint.model.Shape;
import esi.atl.g43335.asciiPaint.model.Square;

/**
 *
 * @author g43335
 */
public class AsciiPaint {

    private Drawing drawing;

    public AsciiPaint(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width and height must be above 0");
        }
        this.drawing = new Drawing(width, height);
    }

    public AsciiPaint() {
        this.drawing = new Drawing();
    }

    public Drawing getDrawing() {
        return drawing;
    }

    public void newCircle(int x, int y, double radius, char color) {
        Shape shape = new Circle(new Point(x, y), radius, color);
        drawing.addShape(shape);
    }

    public void newRectangle(int x, int y, double width, double height, char color) {
        Shape shape = new Rectangle(new Point(x, y), width, height, color);
        drawing.addShape(shape);
    }

    public void newSquare(int x, int y, double width, double height, char color) {
        Shape shape = new Square(new Point(x, y), width, height, color);
    }
    
        public String asAscii(){
        StringBuilder builder = new StringBuilder();
        builder.append("");
        for(int i = 0; i < this.drawing.getWidth(); i++){
            for(int j = 0; j < this.drawing.getHeight(); j++){
                if(this.drawing.getShapeAt(new Point(i, j)) == null){
                    builder.append(" ");
                }else{
                    builder.append(this.drawing.getShapeAt(new Point(i, j)).getColor());
                }
                if(j == this.drawing.getHeight() - 1){
                    builder.append("\n");
                }
            }
        }
        return builder.toString();
    }

}
