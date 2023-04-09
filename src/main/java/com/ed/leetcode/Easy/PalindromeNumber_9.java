package com.ed.leetcode.Easy;

public class PalindromeNumber_9 {
/*
    Given an integer x, return true if x is a  palindrome, and false otherwise.

    Example 1:

    Input: x = 121
    Output: true
    Explanation: 121 reads as 121 from left to right and from right to left.
    Example 2:

    Input: x = -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
    Example 3:

    Input: x = 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public static void main(String[] args) {
    System.out.println(isPalindrome(121));
    System.out.println(isPalindrome(-121));
    System.out.println(isPalindrome(10));
}
    public static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }
        String numberStr = String.valueOf(number);
        StringBuilder complax = new StringBuilder();
        for (int i = numberStr.length()-1; i >=0 ; i--) {
            complax.append(numberStr.charAt(i));
        }
        return complax.toString().equals(numberStr);
    }
}
