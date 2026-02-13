package com.bengre.educative.io.twopointers;

public class StringCompressionV1 {

    public int compress(char[] chars) {
        if(chars.length == 1){
            return 1;
        }
        int n = chars.length;
        int i, j, k;
        i=k=0;
        while (i < n) {
            j = i;
            while (j < n && chars[i] == chars[j]) {
                j++;
            }
            int diff = j - i;
            if (diff == 1) {
                chars[k] = chars[i];
                k++;
            } else {
                chars[k] = chars[i];
                k++;
                String s = String.valueOf(diff);
                for (char c: s.toCharArray()) {
                    chars[k] = c;
                    k++;
                }
            }
            i = j;
        }
        return k;
    }
}
