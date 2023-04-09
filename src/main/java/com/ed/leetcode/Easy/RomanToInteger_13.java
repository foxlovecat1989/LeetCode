package com.ed.leetcode.Easy;

import java.util.ArrayList;
import java.util.List;

public class RomanToInteger_13 {

    /*
    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    Example 1:

    Input: s = "III"
    Output: 3
    Explanation: III = 3.
    Example 2:

    Input: s = "LVIII"
    Output: 58
    Explanation: L = 50, V= 5, III = 3.
    Example 3:

    Input: s = "MCMXCIV"
    Output: 1994
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

     */
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
    public static int romanToInt(String roman) {
            List<Integer> numberList = new ArrayList<>();
        // 轉換roman to int
        convertRoman(roman, numberList);
        return countNumbers(numberList);

    }

    private static int countNumbers(List<Integer> numberList) {
        int count = 0, i = 0;
        while (i < numberList.size()) {
            if (i < numberList.size() - 1 &&numberList.get(i) < numberList.get(i + 1)) {
                count += numberList.get(i + 1) - numberList.get(i);
                i += 2;
            } else {
                count += numberList.get(i);
                i++;
            }
        }
        return count;
    }

    private static void convertRoman(String roman, List<Integer> numberList) {
        for (int i = 0; i < roman.length(); i++) {
            switch (roman.charAt(i)) {
                case 'I' -> numberList.add(1);
                case 'V' -> numberList.add(5);
                case 'X' -> numberList.add(10);
                case 'L' -> numberList.add(50);
                case 'C' -> numberList.add(100);
                case 'D' -> numberList.add(500);
                case 'M' -> numberList.add(1000);
                default -> throw new IllegalArgumentException("錯誤的參數 : " + roman.charAt(i));
            }
        }
    }
}
