package LeetCode;

import java.util.HashSet;
import java.util.Set;


public class Problem {
	public static void main(String[] args){
		new Problem().lengthOfLongestSubstring("eeeeeeeeeese");
	}
	public int[] twoSum(int[] nums,int target){

//		problem 1
		int[] result = new int[2];
		for(int i=0;i<nums.length;i++){
			for(int j=i;j<nums.length;j++){
				if((nums[i]+nums[j])==target) {
					result[0]=i+1;
					result[1]=j+1;
					return result;
				}
			}
		}
		return result;
	}
	
//===============================================================================
    public int lengthOfLongestSubstring(String s) {
//    	problem 3  Input: abcabcbb  Output: abc 3
        if(s==null || s.length()==0) return 0;
        HashSet<Character> buffer = new HashSet<Character>();
        int result =0;
 /*
 *
       for(int i=0;i<s.length();i++){
    	   for(int j=i;j<s.length();j++){    		   
	          if(buffer.contains(s.charAt(j))) { 
	        	  buffer.clear();
	        	  break;
	          }else {
	        	  buffer.add(s.charAt(j));
	          }
              if(buffer.size()>result)  result = buffer.size();
    	   }
       }
 */   
        int left=0;
        int right=0;
        while(right<s.length()){
        	if(buffer.contains(s.charAt(right))){
        		if(right-left>result) result = right-left;
        		while(s.charAt(left)!=s.charAt(right)){
        			buffer.remove(s.charAt(left));
        			left++;
        		}
        		left++;
        	
        	}else{
        		buffer.add(s.charAt(right));
        	
        	}
        	right++;
        }
       
        result=Math.max(result,right-left);

        return result;
    }
    
//=============================================================================    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     //Median of Two Sorted Arrays
    	int total = nums1.length+nums2.length;
    	if(total%2 ==0){
    		return (findKthNum(total/2+1,nums1,nums2)+findKthNum(total/2,nums1,nums2))/2;

    	}else{
    		return findKthNum(total/2+1,nums1,nums2);
    	}
    	
    }
	
    public double findKthNum(int k,int[] nums1, int[] nums2){
    	if(nums1.length>nums2.length) return findKthNum(k,nums2,nums1);
    	if(nums1.length==0) return nums2[k-1];
    	if(k==1) return nums1[0]<nums2[0] ? nums1[0] : nums2[0];
    	
    	int pivot = Math.min(k/2, nums1.length);
    	
    	
    	if(nums1[pivot-1]>nums2[k-pivot-1]){
    		int[] newArray = new int[nums2.length-k+pivot];
    		for(int i=0;i<newArray.length;i++){
    			newArray[i] = nums2[i+k-pivot];
    		}
    		return findKthNum(pivot,nums1,newArray);
    	}else if(nums1[pivot-1]<nums2[k-pivot-1]){
    		int[] newArray = new int[nums1.length-pivot];
    		for(int i=0;i<newArray.length;i++){
    			newArray[i] = nums1[i+pivot];
    		}
    		return findKthNum(k-pivot,newArray,nums2);
    	}else{
    		return nums1[pivot-1];
    	}
    
    }
    
    //=====================================================================================
    public String longestPalindrome(String s) {
	// longest palindromic substring
	
     return null;   
    }

	 
	
	   
	
}
