package sprint02;

/*
https://leetcode.com/problems/sqrtx/
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:
Input: 4
Output: 2

Example 2:
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.
 */
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
