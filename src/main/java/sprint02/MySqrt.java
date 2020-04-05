package sprint02;

public class MySqrt {
    public static int mySqrt(int x) {
//        edge case
        if (x == 0) return 0;

        int start = 1;
        int end = x;
        while (start < end) {
            int middle = (start + (end - start)) / 2;
            if (middle <= x / middle && (middle + 1) > x / (middle + 1)) {
                return middle;
            } else {
                if (middle > x / middle) {
                    end = middle;
                } else {
                    start = middle + 1;
                }
            }
        }
        return start;
    }
}
