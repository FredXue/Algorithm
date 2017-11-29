package com.fredxue.LeetCode;

import java.util.HashMap;

/**
 * Created by fredxue on 11/11/2017.
 */
public class QuickSelect {

    public int findKthLargest(int[] nums, int k) {
        if(nums.length < 1) return -1;
        return quickSelect(nums, 0, nums.length-1, nums.length - k + 1);
    }

    public int quickSelect(int[] nums, int l, int r, int k) {
        if(l == r) return nums[l];
        int pivot = nums[l];
        int lo = l +1;
        int hi = r;
        while(lo <= hi) {
            while(lo <= hi && nums[lo] >= pivot) lo++;
            while(lo <= hi && nums[hi] < pivot) hi--;
            if(lo < hi) swap(nums, lo, hi);
        }
        swap(nums, l, hi);

        int count = hi - l + 1;
        if(count == k) return nums[k];
        else if (count > k) return quickSelect(nums, l, hi -1, k);
        else return quickSelect(nums, hi+ 1, r ,k - count);
    }


    public void swap(int[] nums, int i, int j) {
        final int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {-1,2,0};
        System.out.println(0xffffffff);
    }
}
