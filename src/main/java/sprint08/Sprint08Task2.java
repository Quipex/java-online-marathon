package sprint08;

import java.util.Arrays;
import java.util.function.Consumer;

public class Sprint08Task2 {
    /*
        Please, create a static Consumer implementation cons that takes an array of doubles as a parameter and changes
        it using the next rule: all values that are greater than 2 should be multiplied by 0.8, and other values
        should be multiplied by 0.9.

        Also, please. implement a static method getChanged that takes an array of doubles as a first parameter and
        Consumer as a second. The method should return an array changed by the second parameter.

        getChanged method should not change initial array.
         */
    public static double[] getChanged(double[] initialArray, Consumer<double[]> consumer) {
        double[] copiedArray = Arrays.copyOf(initialArray, initialArray.length);
        consumer.accept(copiedArray);
        return copiedArray;
    }

    static Consumer<double[]> cons = (doubles -> {
        for (int i = 0; i < doubles.length; i++) {
            if (doubles[i] > 2) {
                doubles[i] = doubles[i] * 0.8;
            } else {
                doubles[i] = doubles[i] * 0.9;
            }
        }
    });
}
