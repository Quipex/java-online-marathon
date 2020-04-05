package sprint02;


/*
https://leetcode.com/problems/reverse-integer/
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
[−2^31,  2^31 − 1]. For the purpose of this problem,
assume that your function returns 0 when the reversed integer overflows.
 */

class ReverseInteger {
    public static int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int lastDigit = x % 10;
            if ((reversed > Integer.MAX_VALUE / 10) || (reversed < Integer.MIN_VALUE / 10)) {
                return 0;
            }
            if ((reversed == Integer.MAX_VALUE / 10 && lastDigit > 7) ||
                (reversed == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0;
            }
            reversed = reversed * 10 + lastDigit;
            x /= 10;
        }
        return reversed;
    }
}
