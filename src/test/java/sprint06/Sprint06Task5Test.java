package sprint06;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static sprint06.Sprint06Task5.*;

class Sprint06Task5Test {
    /*
    For example, for a given list
    [Espresso [name=Espresso, rating=8], Cappuccino [name=Cappuccino, rating=10],
    Espresso [name=Espresso, rating=10],
    Cappuccino [name=Cappuccino, rating=6], Caffee [name=Caffee, rating=6]]
    you should get
    {Espresso=9.00, Cappuccino=8.00, Caffee=6.00}
     */

    private Object[] testSet = new Object[] {

    };

    @Test
    public void test() {
        Map<String, Double> expected = new HashMap<>();
        expected.put("Espresso", 9.00);
        expected.put("Cappuccino", 8.00);
        expected.put("Caffee", 6.00);

        Caffee[] tested = new Caffee[]{
                new Espresso("Espresso", 8),
                new Cappuccino("Cappuccino", 10),
                new Espresso("Espresso", 10),
                new Cappuccino("Cappuccino", 6),
                new Caffee("Caffee", 6)
        };

        Map<String, Double> actual = MyUtils.averageRating(Arrays.asList(tested));

        assertEquals(expected, actual);
    }
}
