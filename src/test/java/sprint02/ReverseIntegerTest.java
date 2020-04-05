package sprint02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {
    @Test
    public void test() {
        assertEquals(0, reverse(-1234567889));
        assertEquals(0, reverse(Integer.MIN_VALUE));
        assertEquals(-1, reverse(-1));
        assertEquals(-12, reverse(-21));
        assertEquals(-123, reverse(-321));
        assertEquals(-1234, reverse(-4321));
        assertEquals(-2147483641, reverse(-1463847412));
    }

    private int reverse(int x) {
        return ReverseInteger.reverse(x);
    }
}
