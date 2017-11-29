package com.fredxue.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fredxue on 22/11/2017.
 */
public class WoodCut {


    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{1,2,3,4,5,6,2,9,9,3,1,3,8,4,7,8,2,3,4,9,0,1,2,4}, 4));
    }


    public static int maxSum(int[] nums, int n) {
        int[] count = new int[10];
        for(int number : nums) {
            count[number] ++;
        }
        int ans = 0;

        for(int i = 9; i>=0; i--) {
            if(count[i] <= n) {
                n -= count[i];
                ans += count[i] * i;
            } else {
                ans += n * i;
                n = 0;
                break;
            }
        }

        return ans;
    }


    public static int dotProduct(int[] v1, int[] v2) {
        List<int[]> vector1 = new ArrayList<>();
        List<int[]> vector2 = new ArrayList<>();
        for(int i = 0; i<v1.length; i++) {
            if(v1[i] > 0) {
                int[] pair = new int[]{i, v1[i]};
                vector1.add(pair);
            }
            if(v2[i] > 0) {
                int[] pair = new int[]{i, v2[i]};
                vector2.add(pair);
            }
        }

        return 0;
    }
}
