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
    
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
     //Median of Two Sorted Arrays
    	
    	return 0.0f;
    }
	 

	 
	
	   
	
}
