package com.bengre.educative.io.twopointers;

public class ReverseWordsV1 {

    public static String reverseWords(String sentence) {
        char[] ch = sentence.toCharArray();
        int n = ch.length;
        StringBuilder res = new StringBuilder();
        int i = n-1;
        if (n < 2) {
            return sentence;
        }
        while (i>=0) {
            if (ch[i] == ' ') {
                i--;
            } else {
                int j = i;
                while(j >= 0 && ch[j] != ' ') {
                    j--;
                }
                int k = j+1;
                while(k <= i) {
                    res.append(ch[k]);
                    k++;
                }
                res.append(' ');
                i = j-1;
            }
        }

        return res.deleteCharAt(res.length() - 1).toString();

    }
}
