package com.bengre.educative.io.slidingwindow;

public class LongestSubstringV1 {

    public int findLongestSubstring(String str) {
        if(str.length() == 1) {
            return 1;
        }
        char[] c = str.toCharArray();

        int n = c.length;
        int large = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        while (right < n) {
            if (sb.indexOf(String.valueOf(c[right])) != -1) {
                System.out.println(sb.toString());
                sb.delete(0, sb.indexOf(String.valueOf(c[right])) + 1);
                System.out.println(sb.toString());
            }
            sb.append(String.valueOf(c[right]));
            large = Math.max(sb.length(), large);
            right++;
        }
        System.out.println(sb.toString());
        large = Math.max(sb.length(), large);


        return large;


    }
}
