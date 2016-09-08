package com.fredxue.Sort;

import java.util.Collections;

public class QuickSort {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Integer[] test ={1,3,7,2,3,5,7,2,1,3,8,6,9,0,2};
        sort(test);
        for(Integer i:test) System.out.println(i);
	}

	public static int partition(Comparable[] a,int lo, int hi){
	    int i =lo;
	    int j= hi+1;
	    while(true){
	        while(Sort.less(a[++i], a[lo]))
	        	if(i==hi) break;
	        
	        while(Sort.less(a[lo], a[--j]))
	        	if(j==lo) break;
	    	
	    	if(i>=j) break;
	    	Sort.exch(a, i, j);
	    }
	    
	    Sort.exch(a, lo, j); 
	    return j;
	     
	}
	
	public static void sort(Comparable[] a){
	  sort(a,0,a.length-1);
	}
	
	public static void sort(Comparable[] a, int lo, int hi){
		if(lo>=hi) return;
		int j = partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	
}
