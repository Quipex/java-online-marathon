package sprint10;

public class Sprint10Task4 {
    static class ArrayUtil {

        public static <T extends Number> double averageValue(Array<T> array) {
            double sum = 0;
            int quantity = array.length();
            for (int i = 0; i < quantity; i++) {
                sum += array.get(i).doubleValue();
            }
            return sum / quantity;
        }

    }

    static class Array<T> {
        private T[] array;

        public Array(T[] array) {
            this.array = array;
        }

        public T get(int index) {
            return array[index];
        }

        public int length() {
            return array.length;
        }
    }
}
