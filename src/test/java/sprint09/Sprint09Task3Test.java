package sprint09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sprint09Task3Test {
    @Test
    void test() {
        String expected = "F";
        String actual = Sprint09Task3.MyUtils.pigLatinConverter("F");
        assertEquals(expected, actual);
    }
}
