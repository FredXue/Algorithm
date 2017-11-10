package com.fredxue.LeetCode;

import java.util.*;

/**
 * Created by fredxue on 15/10/2017.
 */
public class Solution {

    public static int answer(int[] x, int[] y) {

        // Your code goes here.
        int[] count = new int[2001];
        int[] big = null, small = null;
        if(x.length > y.length){
            big = x;
            small = y;
        } else {
            big = y;
            small = x;
        }

        for(int n : small) count[n+1000]++;

        for(int n : big){
            count[n+1000]--;
            if(count[n+1000] < 0) return n;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("absc12dasf3s=adf133".split("[a-zA-Z]+")[0]);

    }
}
