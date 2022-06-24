package com.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestConsective {
    public static void main(String[] args) {
        int[] array = {9, 3, 10, 4, 20, 2};

        LongestConsective obj = new LongestConsective();
        System.out.println(obj.longValue(array));
    }

    private int longValue(int[] array) {

       /* int max = Integer.MIN_VALUE;
        Arrays.sort(array);
        for (int i = 1; i <= array.length; i++) {
            int ans = 1;
            if (array[i] - array[i - 1] == 1) {
                ans++;
            } else {
                max = Math.max(ans, max);
            }
        }
        return max;*/

        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], 0);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = 1;
            if (!map.containsKey(entry.getKey() - 1)) {
                //found starting point
                int start = entry.getKey();
                while (map.containsKey(start++)) {
                    count++;
                    start++;
                }
            }

            max = Math.max(count, max);

        }


        return max;
    }
}
