package sprint09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sprint09Task5Test {

    @Test
    void test() {
        String test = "Java    was      originally developed\n" +
                "   by    James   Gosling at Sun Microsystems (which\n" +
                " has since been\n" +
                "acquired by Oracle) and released in 1995\n" +
                " as a core component of Sun Microsystems' Java platform.";
        String expected = "Java was originally developed by James Gosling at Sun\n" +
                "Microsystems (which has since been acquired by Oracle) and\n" +
                "released in 1995 as a core component of Sun Microsystems'\n" +
                "Java platform.";
        assertEquals(expected, Sprint09Task5.MyUtils.reformatLines(test));
    }
}
