package by.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

    @Test
    public void testPoint1() {
        Point p = new Point(6);
        Point p2 = new Point(8);
        Assert.assertEquals(p.distance(p2), 10.0);
    }
    @Test
    public void testPoint2() {
        Point p = new Point(12);
        Point p2 = new Point(13);
        Assert.assertNotEquals(p.distance(p2), 16.0);
    }
    @Test
    public void testPoint3() {
        Point p = new Point (-5);
        Point p2 = new Point(-6);
        Assert.assertNotEquals(p.distance(p2), -15.0);
    }

    @Test
    public void testPoint4() {
        Point p = new Point (0);
        Point p2 = new Point(-1);
        Assert.assertEquals(p.distance(p2), 1.0);
    }
}
