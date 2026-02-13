package com.bengre.educative.io.twopointers;

public class SortColorsV1 {

    public int[] sortColors (int[] colors) {
        int n = colors.length;
        for (int i = 0; i < n-1; i++){
            for (int j = i+1; j < n; j++) {
                if (colors[i] > colors[j]) {
                    int temp = colors[i];
                    colors[i] = colors[j];
                    colors[j] = temp;
                }
            }
        }
        return colors;
    }

}
