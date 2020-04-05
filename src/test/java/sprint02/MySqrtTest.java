package sprint02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySqrtTest {
    @Test
    public void test() {
        assertEquals(2, sqrt(8));
        assertEquals(2, sqrt(4));
        assertEquals(8, sqrt(64));
    }

    private int sqrt(int i) {
        return MySqrt.mySqrt(i);
    }
}
