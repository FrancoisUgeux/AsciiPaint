package model;

import java.util.List;

/**
 *
 * @author g43335
 */
public class Drawing {
    private List<Shape>shapes;
    private int height;

    public Drawing(List<Shape> shapes, int height, int width) {
        this.shapes = shapes;
        this.height = height;
        this.width = width;
    }
    private int width;
}
