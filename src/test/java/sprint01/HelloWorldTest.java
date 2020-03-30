package sprint01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {
    @Test
    void doubleNumber() {
        assertEquals(HelloWorld.doubleNumber(2), 4);
    }

    @Test
    void century() {
        assertEquals(HelloWorld.century(1), 1);
        assertEquals(HelloWorld.century(100), 1);
        assertEquals(HelloWorld.century(101), 2);
        assertEquals(HelloWorld.century(200), 2);
    }

    @Test
    void sumOfDigits() {
        assertEquals(HelloWorld.sumOfDigits(101), 2);
        assertEquals(HelloWorld.sumOfDigits(211), 4);
        assertEquals(HelloWorld.sumOfDigits(100), 1);
        assertEquals(HelloWorld.sumOfDigits(345), 12);

    }

    @Test
    void isLeapYear() {
        assertEquals(HelloWorld.isLeapYear(4), true);
        assertEquals(HelloWorld.isLeapYear(7), false);
        assertEquals(HelloWorld.isLeapYear(8), true);
//        div by 400
        assertEquals(HelloWorld.isLeapYear(800), true);
//        not div by 4 or 400
        assertEquals(HelloWorld.isLeapYear(200), false);
    }
}
