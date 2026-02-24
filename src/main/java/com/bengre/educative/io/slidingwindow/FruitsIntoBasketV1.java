package com.bengre.educative.io.slidingwindow;

import java.util.HashMap;

public class FruitsIntoBasketV1 {
    public int totalFruit(int[] fruits) {
        if (fruits.length == 1) {
            return 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        int low = 0;
        int maxLength = 0;
        for (int high = 0; high < fruits.length; high++) {
            if (!map.containsKey(fruits[high])) {
                map.put(fruits[high], 1);
            } else {
                Integer current = map.get(fruits[high]);
                map.put(fruits[high], current + 1);
            }
            maxCount = Math.max(maxCount, map.get(fruits[high]));
            while (map.size() > 2) {
                Integer current = map.get(fruits[low]);
                if (current == 1) {
                    map.remove(fruits[low]);
                } else {
                    map.put(fruits[low], current - 1);
                }
                low++;
            }

            maxLength = Math.max(maxLength, high - low +1);
        }

        return maxLength;

    }
}
