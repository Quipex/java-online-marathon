package sprint09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sprint09Task2Test {
    @Test
    void test() {
        assertTrue(Sprint09Task2.MyUtils.verifyBrackets("{(())}"));
    }
}
