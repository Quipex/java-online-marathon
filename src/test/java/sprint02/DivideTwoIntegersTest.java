package sprint02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideTwoIntegersTest {

    @Test
    public void test() {
        assertEquals(2, divide(5, 2));
        assertEquals(2, divide(8, 4));
        assertEquals(2, divide(23, 11));
        assertEquals(2, divide(32, 11));
        assertEquals(-2, divide(-32, 11));
        assertEquals(-20000000, divide(120000000, -6));
        assertEquals(2147483647, divide(Integer.MIN_VALUE, -1));
    }

    private int divide(int n1, int n2) {
        return DivideTwoIntegers.divide(n1, n2);
    }


}
