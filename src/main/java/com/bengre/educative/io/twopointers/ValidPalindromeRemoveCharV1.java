package com.bengre.educative.io.twopointers;

public class ValidPalindromeRemoveCharV1 {

    public boolean isPalindrome(String string) {
        char[] arr = string.toCharArray();
        int n = arr.length;
        int lettersRemoved = 0;
        int low = 0; int high = n-1;
        if (n == 1) {
            return true;
        }
        while (low <= high){
            if (lettersRemoved > 1) {
                return false;
            }
            if (arr[low] != arr[high]) {
                lettersRemoved++;
                if (arr[low] == arr[high-1]) high--;
                if(arr[low+1] == arr[high]) low++;
            } else {
                low++;
                high--;
            }
        }
        return true;
    }
}
