import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Point;

public class PointTests {

    @Test
    public void testDistance() {
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,5);

        Assert.assertEquals(p1.distance(p2),5.0);
    }

    @Test
    public void testDistance1() {
        Point p1 = new Point(0,0);

//        System.out.printf("Расстояние между двумя точками = %s единиц%n", distance(p1, p2));
        Assert.assertEquals(p1.distance(p1),0.0);
    }

    @Test
    public void testDistance2() {

        Point p2 = new Point(0,5);

//        System.out.printf("Расстояние между двумя точками = %s единиц%n", distance(p1, p2));
        Assert.assertEquals(p2.distance(p2),0.0);
    }


}
