package com.fredxue.interview.facebook;

/**
 * Created by fredxue on 28/11/2017.
 */
public class WoodCut {
    public  static int woodCut(int[] L, int T) {
        int len = 0;
        for(int i:L){
            len = Math.max(len,i);
        }
        int lo = 1, hi = len;
        while(lo<=hi){ // HERE!!
            int mid = (hi-lo)/2+lo;
            int c =count(L,mid);
            if(c<T){
                hi = mid - 1;
            }
            else if(c>=T){
                lo = mid+1;
            }
        }
        return hi;
    }

    public static int count(int[] L, int k){
        int res = 0;
        for(int i: L){
            res+=i/k;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(woodCut(new int[]{232, 124, 456}, 7));
    }

}
