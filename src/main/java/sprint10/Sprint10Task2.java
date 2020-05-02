package sprint10;

public class Sprint10Task2 {
    static class ArrayUtil {
        public static <T> T setAndReturn(T[] array, T value, int index) {
            array[index] = value;
            return array[index];
        }
    }
}
