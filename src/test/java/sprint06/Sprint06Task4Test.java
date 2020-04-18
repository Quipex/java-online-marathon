package sprint06;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static sprint06.Sprint06Task4.*;

class Sprint06Task4Test {
    @Test
    public void test() {
        Shape[] expected = new Shape[]{
                new Circle(null, 2),
                new Rectangle(null, 2, 3),
                new Rectangle(null, 3, 2),
        };

        Shape[] testList = new Shape[]{
                new Circle(null, 2),
                new Rectangle(null, 2, 3),
                new Circle(null, 1),
                new Rectangle(null, 3, 2),
                new Circle(null, 0.5),
                new Rectangle(null, 1, 2),
        };

        List<Shape> res = MyUtils.maxAreas(Arrays.asList(testList));
        assertEquals(Arrays.asList(expected), res);
    }

}
