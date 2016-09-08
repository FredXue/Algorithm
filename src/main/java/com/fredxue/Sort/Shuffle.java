package com.fredxue.Sort;

public class Shuffle {

	/**
	 * @Title main
	 * @Discription
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static void shufle(Integer[] a){
		int length= a.length;
		for(int i=0;i<length;i++){
			int r =Shuffle.uniform(i+1);
			Sort.exch(a,i,r);
		}
	}

	public static int uniform(int a){
		//怎样均匀随机
		
		
		return a;
		
	}
}
