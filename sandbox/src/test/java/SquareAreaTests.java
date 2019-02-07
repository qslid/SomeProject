import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Square;

public class SquareAreaTests {

    @Test
    public void testArea(){
        Square square = new Square(4);
        Assert.assertEquals(square.area(),16.0);
    }

    @Test
    public void testArea1(){
        Square square1 = new Square(0);
        Assert.assertEquals(square1.area(),0.0);

    }
    @Test
    public void testArea2(){
        Square square2 = new Square(-1);
        Assert.assertEquals(square2.area(),1.0);

    }
    @Test
    public void testArea3(){
        Square square3 = new Square(6);
        Assert.assertEquals(square3.area(),42.0);

    }

    @Test
    public void testArea4(){
        Square square4 = new Square(6);
        Assert.assertNotEquals(square4.area(),36);

    }

    @Test
    public void testArea5(){
        Square square5 = new Square(6.5);
        Assert.assertEquals(square5.area(),42.25);

    }
}
