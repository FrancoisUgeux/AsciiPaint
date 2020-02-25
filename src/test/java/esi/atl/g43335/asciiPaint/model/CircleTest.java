package esi.atl.g43335.asciiPaint.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author franc
 */
public class CircleTest {

    public CircleTest() {
    }

    @Test
    public void testGetCenter() {
        System.out.println("getCenter");
        Circle instance = new Circle(new Point(4, 4), 4, 'a');
        Point expResult = new Point(4, 4);
        Point result = instance.getCenter();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetRadius() {
        System.out.println("getRadius");
        Circle instance = new Circle(new Point(4, 4), 4, 'a');
        double expResult = 4.0;
        double result = instance.getRadius();
        assertEquals(expResult, result);
    }

    @Test
    public void testMove() {
        System.out.println("move");
        double dx = 1.0;
        double dy = 2.0;
        Circle instance = new Circle(new Point(10, 10), 5, 'y');
        Circle expResult = new Circle(new Point(11, 12), 5, 'y');
        instance.move(dx, dy);
        assertEquals(instance, expResult);
    }

    @Test
    public void testIsInside() {
        System.out.println("isInside");
        Point p = new Point(2, 2);
        Circle instance = new Circle(p, 5, 'r');
        boolean expResult = true;
        boolean result = instance.isInside(p);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsInsideFalse() {
        System.out.println("isNotInside");
        Point p = new Point(2, 2);
        Circle instance = new Circle(p, 5, 'r');
        boolean expResult = false;
        boolean result = instance.isInside(new Point(20, 20));
        assertEquals(expResult, result);
    }

}
