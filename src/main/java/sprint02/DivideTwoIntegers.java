package sprint02;

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
//        the only case of overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        int sign = -1;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            sign = 1;
        }

        dividend = abs(dividend);
        divisor = abs(divisor);
        int result = 0;
        while (dividend - divisor >= 0) {
            int x = 0;
            while (dividend - (divisor << 1 << x) >= 0) {
                x++;
            }
            result += 1 << x;
            dividend -= divisor << x;
        }
        return result * sign;
    }

    private static int abs(int number) {
        return number < 0 ? -number : number;
    }
}
