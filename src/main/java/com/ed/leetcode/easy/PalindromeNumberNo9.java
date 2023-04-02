package com.ed.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class PalindromeNumberNo9 {
//
//    Given an integer x, return true if x is a palindrome, and false otherwise.
//
//    Example 1:
//
//    Input: x = 121
//    Output: true
//    Explanation: 121 reads as 121 from left to right and from right to left.
//
//
//    Example 2:
//
//    Input: x = -121
//    Output: false
//    Explanation: From left to right, it reads -121. From right to left,  it becomes 121-.
//    Therefore, it is not a palindrome.
//
//
//    Example 3:
//
//    Input: x = 10
//    Output: false
//    Explanation: Reads 01 from right to left. Therefore, it is not a palindrome.
//
//
//    Constraints:
//    -231 <= x <= 231 - 1
//
//
//    Follow up: Could you solve it without converting the integer to a string?

    public static void main(String[] args) {
        int x1 = 121;
        boolean result1= isPalindrome(x1);
        log.debug("result1: {}", result1);

        int x2 = -121;
        boolean result2 = isPalindrome(x2);
        log.debug("result2: {}", result2);

        int x3 = 10;
        boolean result3 = isPalindrome(x3);
        log.debug("result3: {}", result3);
    }

    private static boolean isPalindrome(int x) {
        String input = String.valueOf(x);
        String[] inputs = input.split("");
        if (!isFirstElementIsANumber(inputs))
            return false;
        if (inputs.length < 2)
            return true;

        return input.equals(getProcessedData(inputs));
    }

    private static String getProcessedData(String[] inputs) {
        Deque<String> datas = new LinkedList<>();
        Arrays.stream(inputs).forEach(datas::push);
        List<String> outputs = new LinkedList<>();
        while (!datas.isEmpty())
            outputs.add(datas.pop());

        return String.join("", outputs);
    }

    private static boolean isFirstElementIsANumber(String[] inputs) {
        try {
            Integer.parseInt(inputs[0]);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
