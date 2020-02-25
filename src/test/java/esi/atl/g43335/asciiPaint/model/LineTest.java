package esi.atl.g43335.asciiPaint.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author franc
 */
public class LineTest {

    public LineTest() {
    }

    @Test
    public void testMove() {
        System.out.println("move");
        double dx = 4.0;
        double dy = 4.0;
        Line instance = new Line(new Point(4, 4), new Point(8, 8), 'y');
        Line expResult = new Line(new Point(8, 8), new Point(12, 12), 'y');
        instance.move(dx, dy);
        assertEquals(instance, expResult);
    }

    @Test
    public void testIsInside() {
        System.out.println("isInside");
        Point p = new Point(6, 4);
        Line instance = new Line(new Point(4, 4), new Point(8, 4), 'y');
        boolean expResult = true;
        boolean result = instance.isInside(p);
        assertEquals(expResult, result);
    }
}
