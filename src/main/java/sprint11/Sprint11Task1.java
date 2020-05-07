package sprint11;

public class Sprint11Task1 {
    static class Operation{
        public static  int squareRectangle(int a, int b) throws IllegalArgumentException {
            if(a < 0 || b < 0) {
                throw new IllegalArgumentException("Negative values are not " +
                        "allowed: a=" + a + ", b=" + b);
            }
            return a * b;
        }

        public static int trySquareRectangle(int a, int b) {
            try {
                return squareRectangle(a, b);
            } catch(IllegalArgumentException e) {
                return 0;
            }
        }
    }
}
