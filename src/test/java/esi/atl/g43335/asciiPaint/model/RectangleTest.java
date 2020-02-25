package esi.atl.g43335.asciiPaint.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author franc
 */
public class RectangleTest {

    public RectangleTest() {
    }

    @Test
    public void testGetUpperLeft() {
        System.out.println("getUpperLeft");
        Rectangle instance = new Rectangle(new Point(4, 4), 4, 4, 'y');
        Point expResult = new Point(4, 4);
        Point result = instance.getUpperLeft();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        Rectangle instance = new Rectangle(new Point(4, 4), 4, 4, 'y');
        double expResult = 4.0;
        double result = instance.getWidth();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        Rectangle instance = new Rectangle(new Point(4, 4), 4, 4, 'y');
        double expResult = 4.0;
        double result = instance.getHeight();
        assertEquals(expResult, result);
    }

    @Test
    public void testMove() {
        System.out.println("move");
        double dx = 4.0;
        double dy = 4.0;
        Rectangle instance = new Rectangle(new Point(4, 4), 4, 4, 'y');
        Rectangle expResult = new Rectangle(new Point(8, 8), 4, 4, 'r');
        instance.move(dx, dy);
        assertEquals(instance, expResult);
    }

    @Test
    public void testIsInside() {
        System.out.println("isInside");
        Point p = new Point(4,4);
        Rectangle instance = new Rectangle(new Point(4,4), 4, 4, 'y');
        boolean expResult = true;
        boolean result = instance.isInside(new Point(5,5));
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsNotInside() {
        System.out.println("isNotInside");
        Point p = new Point(4,4);
        Rectangle instance = new Rectangle(new Point(4,4), 4, 4, 'y');
        boolean expResult = false;
        boolean result = instance.isInside(new Point(2,2));
        assertEquals(expResult, result);
    }
}
