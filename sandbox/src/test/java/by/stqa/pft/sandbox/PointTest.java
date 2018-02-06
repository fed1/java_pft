package by.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

    @Test
    public void testPoint1() {
        Point p = new Point(6, 8);
        Assert.assertEquals(p.distance(), 10.0);
    }
    @Test
    public void testPoint2() {
        Point p = new Point(12, 13);
        Assert.assertNotEquals(p.distance(), 16.0);
    }
    @Test
    public void testPoint3() {
        Point p = new Point (-5,-6);
        Assert.assertNotEquals(p.distance(), -15.0);
    }

    @Test
    public void testPoint4() {
        Point p = new Point (0,-1);
        Assert.assertEquals(p.distance(), 1.0);
    }
}
