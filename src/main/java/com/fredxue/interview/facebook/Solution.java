package com.fredxue.interview.facebook;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by fredxue on 28/11/2017.
 */
public class Solution {
    public static boolean checkSubarraySum(int[] nums, int k) {
        //negative
//        if(nums.length < 1) return false;
//        HashSet<Integer> map = new HashSet<>();
//        int sum = 0;
//        for(int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            if(map.contains(sum - k)) return true;
//            map.add(sum);
//        }


        if(nums.length < 1 || k < 0) return false;
        int l = 0, r = 0, sum = 0;
        while(r < nums.length) {
            if(sum == k && r != l) {
                return true;
            } else if(sum > k) {
                sum -= nums[l++];
            }else {
                sum += nums[r++];
            }
        }

        return false;
    }


    public static Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        PriorityQueue<Point> pq = new PriorityQueue<Point>((a, b) -> (int)(distance(a, origin) - distance(b, origin)));
        for(Point p : points) {
            pq.add(p);
        }
        Point[] res = new Point[pq.size()<k? pq.size() : k];
        for(int i = 0; i < res.length; i++){
            res[i] = pq.poll();
        }
        return res;
    }

    public static long distance(Point a, Point b) {
        return ((long)a.x - b.x)^2 + ((long)a.y - b.y)^2;
    }



    public static void main(String[] args) {
        int[] input = new int[]{5,2,3,6,2,3,5,7,8,3,12,3,3,546,73,23,4,5,65};
        System.out.println(checkSubarraySum(input, 0));
        Point[] array = new Point[5];
        array[0] = new Point(4,6);
        array[1] = new Point(4,7);
        array[2] = new Point(4,4);
        array[3] = new Point(2,5);
        array[4] = new Point(1,1);

        for(Point p : kClosest(array, new Point(0, 0), 3)){
            System.out.println(p.x + " " + p.y);
        }

    }
}
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
