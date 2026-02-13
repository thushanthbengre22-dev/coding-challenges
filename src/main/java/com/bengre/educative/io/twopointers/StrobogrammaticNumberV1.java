package com.bengre.educative.io.twopointers;

public class StrobogrammaticNumberV1 {

    public boolean isStrobogrammatic(String num)
    {
        char[] c = num.toCharArray();
        int n = c.length;
        int i = 0; int j = n-1;
        while(i<=j) {
            if (c[i] != mirrorNum(c[j])) {
                return false;
            }
            i++; j--;
        }
        return true;

    }

    private char mirrorNum(char c) {
        return switch (c) {
            case '0' -> '0';
            case '1' -> '1';
            case '6' -> '9';
            case '8' -> '8';
            case '9' -> '6';
            default -> 'n';
        };
    }
}
