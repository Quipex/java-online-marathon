package sprint02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

Coud you solve it without converting the integer to a string?
 */

class PalindromeTest {

    @Test
    public void test() {
        assertEquals(palindrome(-191), false);
        assertEquals(palindrome(0), true);
        assertEquals(palindrome(121), true);
        assertEquals(palindrome(1112111), true);
        assertEquals(palindrome(10000), false);
        assertEquals(palindrome(10001), true);
        assertEquals(palindrome(11), true);
        assertEquals(palindrome(5), true);
        assertEquals(palindrome(-5), false);
        assertEquals(palindrome(Integer.MAX_VALUE), false);
        assertEquals(palindrome(Integer.MIN_VALUE), false);
    }

    private boolean palindrome(int x) {
        return Palindrome.isPalindrome(x);
    }

}
