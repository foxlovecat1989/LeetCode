package com.ed.leetcode.easy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.IntStream;

@Slf4j
public class RomanToIntegerNo13 {
//
//    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//    Symbol       Value
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000

//    For example, 2 is written as II in Roman numeral, just two ones added together.
//    12 is written as XII, which is simply X + II.
//    The number 27 is written as XXVII, which is XX + V + II.
//
//    Roman numerals are usually written largest to smallest from left to right.
//    However, the numeral for four is not IIII. Instead, the number four is written as IV.
//    Because the one is before the five we subtract it making four.
//    The same principle applies to the number nine, which is written as IX.
//    There are six instances where subtraction is used:
//
//    I can be placed before V (5) and X (10) to make 4 and 9.
//    X can be placed before L (50) and C (100) to make 40 and 90.
//    C can be placed before D (500) and M (1000) to make 400 and 900.
//    Given a roman numeral, convert it to an integer.
//
//
//    Example 1:
//
//    Input: s = "III"
//    Output: 3
//    Explanation: III = 3.
//
//
//    Example 2:
//
//    Input: s = "LVIII"
//    Output: 58
//    Explanation: L = 50, V= 5, III = 3.
//
//
//    Example 3:
//
//    Input: s = "MCMXCIV"
//    Output: 1994
//    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
//
//
//    Constraints:
//
//     1 <= s.length <= 15
//    s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
//    It is guaranteed that s is a valid roman numeral in the range [1, 3999].

    public static void main(String[] args) {
        String x1 = "III";
        int result1 = process(x1);
        log.info("result1: {}", result1);

        String x2 = "LVIII";
        int result2 = process(x2);
        log.info("result2: {}", result2);

        String x3 = "MCMXCIV";
        int result3 = process(x3);
        log.info("result3: {}", result3);
    }


    public static int process(String x) {
        String[] datas = x.split("");

        return IntStream.range(0, datas.length)
                .map(index -> {
                    boolean isLastItem = index == datas.length - 1;
                    if (isLastItem)
                        return covertToNumber(datas[index]);

                    return calculateValue(datas[index], datas[index + 1]);
                })
                .sum();
    }

    public static int calculateValue(String firstItem, String secondItem) {
        int currentValue = covertToNumber(firstItem);
        int nextValue = covertToNumber(secondItem);

        return currentValue < nextValue ? -currentValue : currentValue;
    }

    private static int covertToNumber(String number) {
        return RomanNumber.getEnum(number).value;
    }

    @Getter
    @AllArgsConstructor
    public enum RomanNumber {
        I("I", 1),
        V("V", 5),
        X("X", 10),
        L("L", 50),
        C("C", 100),
        D("D", 500),
        M("M", 1000);

        private final String key;
        private final int value;

        public static RomanNumber getEnum(String key) {
            return Arrays.stream(RomanNumber.values())
                    .filter(element -> element.getKey().equals(key))
                    .findAny().orElseThrow(() -> new IllegalArgumentException("無法找到相對應的值"));
        }
    }
}
