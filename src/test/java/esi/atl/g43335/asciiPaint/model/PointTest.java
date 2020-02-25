package esi.atl.g43335.asciiPaint.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author franc
 */
public class PointTest {

    public PointTest() {
    }

    @Test
    public void testGetX() {
        System.out.println("getX");
        Point instance = new Point(4, 4);
        double expResult = 4.0;
        double result = instance.getX();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetY() {
        System.out.println("getY");
        Point instance = new Point(4, 4);
        double expResult = 4.0;
        double result = instance.getY();
        assertEquals(expResult, result);
    }

    @Test
    public void testMove() {
        System.out.println("move");
        double dx = 4.0;
        double dy = 4.0;
        Point instance = new Point(4, 4);
        Point expResult = new Point(8, 8);
        instance.move(dx, dy);
        assertEquals(instance, expResult);
    }

    @Test
    public void testDistanceTo() {
        System.out.println("distanceTo");
        Point other = new Point(4, 4);
        Point instance = new Point(4, 8);
        double expResult = 4.0;
        double result = instance.distanceTo(other);
        assertEquals(expResult, result);
    }
}
