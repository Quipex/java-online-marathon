package sprint05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static sprint05.Sprint05.*;

class Sprint05Test {
    int[][] yearToCourse = new int[][] {
            new int[] {2020, -1},
            new int[] {2019, 1},
            new int[] {2018, 2},
            new int[] {2017, 3},
            new int[] {2016, 4},
            new int[] {2015, 5},
            new int[] {2014, 6},
            new int[] {2013, -1},
    };

    @Test
    public void testCourseCalculation() {
        for (int[] yearToCourse : yearToCourse) {
            System.out.println(Arrays.toString(yearToCourse));
            assertEquals(yearToCourse[1], studentOfYear(yearToCourse[0]).getCourseNumber());
        }

    }

    private Student studentOfYear(int year) {
        return new Student(year, "qwe", "asd");
    }
}
