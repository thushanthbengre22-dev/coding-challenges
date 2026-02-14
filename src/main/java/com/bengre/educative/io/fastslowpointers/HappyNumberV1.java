package com.bengre.educative.io.fastslowpointers;

import java.util.HashSet;
import java.util.Set;

public class HappyNumberV1 {

    public boolean isHappyNumber(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int res = n;
        int square = 0;
        while (res != 1) {
            square = res;
            res = 0;
            while (square != 0) {
                int num = square % 10;
                res = res + (num * num);
                square = square / 10;
                System.out.println(square);
            }
            System.out.println(res);
            if (!set.add(res)) {
                return false;
            }
        }

        return true;

    }
}
