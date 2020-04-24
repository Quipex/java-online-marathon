package sprint08;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Sprint08Task1 {
    public static class MyUtils {
        /*
        Please, implement a static method getCount that takes an array of integers as the first parameter.
        The second parameter - a functional interface that works with integers and defines a condition.

        The method should return the count of elements in the array that satisfy the condition defined by
        the second argument.
         */
        public static int getCount(int[] numbers, Predicate<Integer> predicate) {
            int count = 0;
            for (int number : numbers) {
                if (predicate.test(number)) {
                    count++;
                }
            }
            return count;
        }
    }
}
