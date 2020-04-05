package sprint02;


/*
https://leetcode.com/problems/palindrome-number/
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:
Input: 121
Output: true

Example 2:
Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Follow up:
Could you solve it without converting the integer to a string?
 */

class Palindrome {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        if (x % 10 == 0) return false;
//        11, 22, 33 etc.
        if (x < 100 && x % 11 == 0) return true;

        int reversed = x % 10;
        x /= 10;
        while (x > reversed) {
//        getting the last digit of x each time
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
//        if the original value 12321
        if (reversed > x) {
            reversed /= 10;
        }
        return reversed == x;
    }
}
