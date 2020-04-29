package sprint09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Sprint09Task4Test {
    @Test
    void originalPhrase() {
        String original = "Java is a programming language.";
        String mod = "Java is a   general-purpose programming   language.";
        String expected = "Java is a   GENERAL-PURPOSE programming   language.";
        assertEquals(expected, test(original, mod));
    }

    @Test
    void firstWord() {
        String originalText = "Java is a programming general language";
        String modifyText = "gen4 Java is a general programming general language";
        String expected = "GEN4 Java is a GENERAL programming general language";
        assertEquals(expected, test(originalText, modifyText));
    }

    @Test
    void manySpaces() {
        String originalText = "Java is a general-purpose programming language";
        String modifyText = "Java   is   a   general-purpose   programming   language";
        String expected = "Java   is   a   general-purpose   programming   language";
        assertEquals(expected, test(originalText, modifyText));
    }

    @Test
    void emptyOriginTest() {
        String origin = "";
        String modify = "new";
        String expected = "NEW";
        assertEquals(expected, test(origin, modify));
    }

    @Test
    void oneWord() {
        String originalText = "one";
        String modifyText = "one";
        String result = "one";
        assertEquals(result, test(originalText, modifyText));
    }

    @Test
    void repeating() {
        String orig = "test test";
        String test = "test   test   test";
        String expected = "test   test   TEST";
        assertEquals(expected, test(orig, test));
    }

    private String test(String originalText, String modifyText) {
        return Sprint09Task4.MyUtils.differentWords(originalText, modifyText);
    }
}
