package com.ed.leetcode.Easy;

public class LongestCommonPrefix_14 {

    /*
     Example 1:

     Input: strs = ["flower","flow","flight"]
     Output: "fl"

     Example 2:

     Input: strs = ["dog","racecar","car"]
     Output: ""
     Explanation: There is no common prefix among the input strings.
      */
    public static void main(String[] args) {
        String[] ex1 = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(ex1));
        String[] ex2 = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(ex2));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // 取第一個參數作為比對對象
        String str = strs[0];
        // 針對第一個以後的每個對象進行比對
        for (int i = 1; i < strs.length; i++) {
            // 使用整個字串進行比對，當比對對象與被比對對象不吻合時
            while (strs[i].indexOf(str) != 0) {
                // 比對對象應該要再減少最後一個字在重新進行比對
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }


}
