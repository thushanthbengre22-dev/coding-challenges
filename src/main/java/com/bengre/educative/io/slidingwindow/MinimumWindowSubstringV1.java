package com.bengre.educative.io.slidingwindow;

public class MinimumWindowSubstringV1 {

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int left = 0;
        int right = 0;
        String res = s;
        while (left <= s.length() - t.length()) {
            String temp = s.substring(left,right);
            if (doesItContainAll(t, temp)) {
                if (temp.length() < res.length()) {
                    res = temp;
                }
                System.out.println(temp);
                left++;
            } else {
                if (right < s.length()) {
                    right++;
                } else {
                    break;
                }
            }
        }
        if (res.length() == s.length()) {
            if (doesItContainAll(t,s)) {
                return s;
            } else {
                return "";
            }
        } else {
            return res;
        }


    }

    public Boolean doesItContainAll(String t, String s){
        StringBuilder sb = new StringBuilder(t);
        for(char c: s.toCharArray()) {
            if (sb.indexOf(String.valueOf(c)) != -1) {
                sb.deleteCharAt(sb.indexOf(String.valueOf(c)));
            }
        }
        return (sb.isEmpty());
    }
}
