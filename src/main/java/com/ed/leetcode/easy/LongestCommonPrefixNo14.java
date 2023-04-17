package com.ed.leetcode.easy;

import lombok.extern.slf4j.Slf4j;

import java.util.OptionalInt;
import java.util.stream.IntStream;

@Slf4j
public class LongestCommonPrefixNo14 {
//    Write a function to find the longest common prefix string amongst an array of strings.
//    If there is no common prefix, return an empty string "".
//
//
//    Example 1:
//
//    Input: strs = ["flower","flow","flight"]
//    Output: "fl"
//
//
//    Example 2:
//
//    Input: strs = ["dog","racecar","car"]
//    Output: ""
//    Explanation: There is no common prefix among the input strings.
//
//
//    Constraints:
//
//    1 <= strs.length <= 200
//    0 <= strs[i].length <= 200
//    strs[i] consists of only lowercase English letters.

    public static void main(String[] args) {
        String[] datas1 = new String[]{"flower", "flow", "flight"};
        String result1 = process(datas1);
        log.debug("result1: {}", result1);

        String[] datas2 = new String[]{"dog", "racecar", "car"};
        String result2 = process(datas2);
        log.debug("result2: {}", result2);

        String[] datas3 = new String[]{"ab", "a"};
        String result3 = process(datas3);
        log.debug("result3: {}", result3);

        String[] datas4 = new String[]{"a"};
        String result4 = process(datas4);
        log.debug("result4: {}", result4);

        String[] datas5 = new String[]{"", ""};
        String result5 = process(datas5);
        log.debug("result5: {}", result5);

        String[] datas6 = new String[]{"cir", "car"};
        String result6 = process(datas6);
        log.debug("result6: {}", result6);

        String[] datas7 = new String[]{"aa", "aa"};
        String result7 = process(datas7);
        log.debug("result7: {}", result7);
    }

    private static String process(String[] datas) {
        boolean isOnlyOneElement = datas.length == 1;
        if (isOnlyOneElement)
            return String.join("", datas);

        boolean isTargetBlank = datas[0].length() == 0;
        if (isTargetBlank)
            return "";

        return getLongestCommonPrefix(datas);
    }

    private static String getLongestCommonPrefix(String[] datas) {
        OptionalInt longestCommonPrefixIndex = getLongestCommonPrefixIndex(datas);

        return longestCommonPrefixIndex.isEmpty() ?
                "" :
                datas[0].substring(0, longestCommonPrefixIndex.getAsInt() + 1);
    }

    private static OptionalInt getLongestCommonPrefixIndex(String[] datas) {
        String[] targets = datas[0].split("");

        return IntStream.range(0, targets.length)
                .takeWhile(targetOfIndex -> {
                    String searchStr = targets[targetOfIndex];

                    return IntStream.range(1, datas.length).allMatch(dataOfIndex -> {
                        String item = datas[dataOfIndex];
                        int indexOfSearchStr = item.indexOf(searchStr, targetOfIndex);

                        return targetOfIndex == indexOfSearchStr;
                    });
                })
                .max();
    }
}
