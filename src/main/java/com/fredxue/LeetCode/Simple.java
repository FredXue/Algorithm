package com.fredxue.LeetCode;

public class Simple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] nums = {1,2,3,4,-1,-2,-4,-3,1,2};
     int[] a =solver(nums);
     System.out.println(a.length);
	}
	
	public static int[] solver(int[] nums){
		int start=0;

		int maxLen=0;
		int sum=0;
		for(int i=0;i<nums.length;i++){
			sum=0;
			for(int j=i;j<nums.length;j++){
				sum = sum+nums[j];
				if(sum==0 && j-i+1>maxLen){ 
					start =i;
					maxLen = j-i+1;
				}
			}
			
		}
		
		int[] result  = new int[maxLen];
		for(int i=0;i<maxLen;i++){
			result[i] = nums[start+i];
		}
		return result;
	}

}
