package com.ed.leetcode.Easy;

public class PalindromeNumber_9 {


    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String s = String.valueOf(x);
        String complax ="";
        for (int i = s.length()-1; i >=0 ; i--) {
            complax+= s.substring(i-1,i-1);
        }
        return true;
    }
}
