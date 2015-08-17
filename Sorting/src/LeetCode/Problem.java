package LeetCode;

import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Problem {
	public static void main(String[] args) {
		System.out.println(new Problem().myAtoi("-+1"));
	}

	public int[] twoSum(int[] nums, int target) {

		// problem 1
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if ((nums[i] + nums[j]) == target) {
					result[0] = i + 1;
					result[1] = j + 1;
					return result;
				}
			}
		}
		return result;
	}

	// ===============================================================================
	public int lengthOfLongestSubstring(String s) {
		// problem 3 Input: abcabcbb Output: abc 3
		if (s == null || s.length() == 0)
			return 0;
		HashSet<Character> buffer = new HashSet<Character>();
		int result = 0;
		/*
		 * 
		 * for(int i=0;i<s.length();i++){ for(int j=i;j<s.length();j++){
		 * if(buffer.contains(s.charAt(j))) { buffer.clear(); break; }else {
		 * buffer.add(s.charAt(j)); } if(buffer.size()>result) result =
		 * buffer.size(); } }
		 */
		int left = 0;
		int right = 0;
		while (right < s.length()) {
			if (buffer.contains(s.charAt(right))) {
				if (right - left > result)
					result = right - left;
				while (s.charAt(left) != s.charAt(right)) {
					buffer.remove(s.charAt(left));
					left++;
				}
				left++;

			} else {
				buffer.add(s.charAt(right));

			}
			right++;
		}

		result = Math.max(result, right - left);

		return result;
	}

	// =============================================================================
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// Median of Two Sorted Arrays
		int total = nums1.length + nums2.length;
		if (total % 2 == 0) {
			return (findKthNum(total / 2 + 1, nums1, nums2) + findKthNum(
					total / 2, nums1, nums2)) / 2;

		} else {
			return findKthNum(total / 2 + 1, nums1, nums2);
		}

	}

	public double findKthNum(int k, int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length)
			return findKthNum(k, nums2, nums1);
		if (nums1.length == 0)
			return nums2[k - 1];
		if (k == 1)
			return nums1[0] < nums2[0] ? nums1[0] : nums2[0];

		int pivot = Math.min(k / 2, nums1.length);

		if (nums1[pivot - 1] > nums2[k - pivot - 1]) {
			int[] newArray = new int[nums2.length - k + pivot];
			for (int i = 0; i < newArray.length; i++) {
				newArray[i] = nums2[i + k - pivot];
			}
			return findKthNum(pivot, nums1, newArray);
		} else if (nums1[pivot - 1] < nums2[k - pivot - 1]) {
			int[] newArray = new int[nums1.length - pivot];
			for (int i = 0; i < newArray.length; i++) {
				newArray[i] = nums1[i + pivot];
			}
			return findKthNum(k - pivot, newArray, nums2);
		} else {
			return nums1[pivot - 1];
		}

	}

	// =====================================================================================
	public String longestPalindrome(String s) {
		// longest palindromic substring

		// Brute-force
		// String result="";
		// for(int i=0;i<s.length();i++){
		// for(int j=i+1;j<s.length();j++){
		// String sub = s.substring(i,j);
		// boolean flag= true;
		// for(int k=0;k<=sub.length()/2;k++){
		// if(sub.charAt(k)==sub.charAt(sub.length()-k-1)) continue; else{
		// flag = false;
		// break;
		// }
		// }
		// if(flag && sub.length()>result.length()){
		// result = sub;
		// }
		// }
		// }

		// Dynamic programming O(n^2)time O(n^2)space
		int startIndex = 0;
		int maxLen = 1;
		boolean table[][] = new boolean[1000][1000];
		for (int i = 0; i < s.length(); i++) {
			table[i][i] = true;

		}
		for (int i = 0; i < s.length(); i++) {
			if (i + 1 < s.length()) {
				if (s.charAt(i) == s.charAt(i + 1)) {
					table[i][i + 1] = true;
					startIndex = i;
					maxLen = 2;
				}
			}
		}
		for (int i = 2; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (j + i < s.length()) {
					if (s.charAt(j) == s.charAt(j + i)
							&& table[j + 1][j + i - 1]) {
						table[j][j + i] = true;
						startIndex = j;
						maxLen = i + 1;
					}
				}
			}
		}

		return s.substring(startIndex, startIndex + maxLen);

	}
	
	public String zigzag(String s,int numRows){
		StringBuilder sb = new StringBuilder("");
		int step=0;
		if(numRows==1) return s;
		int part = 2*numRows-2;
		for(int i=0;i<numRows;i++){
			step=0+i;
			while(step<s.length()){
			   sb.append(s.charAt(step));
			   //计算跳步
			   if(i==0 || i==numRows){step+=part;}
			   else if((step+2*i)%part==i){
				  step=step+2*i;
			   }else{
				   step += (part-2*i);
			   }
			   
			}
		}
		return sb.toString();
	}
	
	 public int myAtoi(String str) {
		 if (str == null || str.length() < 1)
				return 0;
		 
			// trim white spaces
			str = str.trim();
		 
			char flag = '+';
		 
			// check negative or positive
			int i = 0;
			if (str.charAt(0) == '-') {
				flag = '-';
				i++;
			} else if (str.charAt(0) == '+') {
				i++;
			}
			// use double to store result
			double result = 0;
		 
			// calculate value
			while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				result = result * 10 + (str.charAt(i) - '0');
				i++;
			}
		 
			if (flag == '-')
				result = -result;
		 
			// handle max and min
			if (result > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
		 
			if (result < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		 
			return (int) result;
	    }
	 
    public boolean isMatch(String s, String p) {

	    	if(s==""){
	    		if(p.length()==2 && p.charAt(1)=='*') return true;
	    		else return false;
	    	}
	    	if(p.charAt(0)=='.'){  
	    		if(p.charAt(1)=='*') return isMatch(s.substring(1),p);

	    		else return isMatch(s.substring(1),p.substring(1));
	    	}
            if(p.charAt(1)=='*'){
            	//match 0 
                  if(isMatch(s,p.substring(2)))  return true;
                // match 1 or more
                  int i =0;
                  while(i<s.length() && ( p.charAt(0)=='.' || p.charAt(0)==s.charAt(0)) ){
                	  if(isMatch(s.substring(i+1),p.substring(2)))
                		  return true;
                	  i++;
                  }
                  return false;
            }else{
            	if(s.length()<1) return false;
            	if(p.charAt(0)=='.' || s.charAt(0)==p.charAt(0)) 
            	   return isMatch(s.substring(1),p.substring(1));
            	else 
            	   return false;
            }

	    }
	    
	    public int maxArea(int[] height) {
	    	int max =0;
	    	int i=0;
	    	int j=height.length-1;
	    	while(true){
	    		if(i==j) break;
	    		int lower =  Math.min(height[i], height[j]);
	    		max = lower*(j-i)>max ? lower*(j-i)  : max;
	    		if(height[i]>height[j])  j--; 
	    		  else  i++;
	    		
	    	}
	    	
	        return max;
	    }
	    
	    public String longestCommonPrefix(String[] strs) {
	        if(strs.length<1) return "";
	        boolean flag = true;
	        int i=0;
	        char c;
	        while(flag){

	            for (int j=0;j<strs.length;j++){
	                if(strs[j].length()<=i){
	                     flag = false;
	                     break;
	                }
	                c=strs[0].charAt(i);
	                if(strs[j].charAt(i)!=c ){
	                     flag = false;
	                     break;
	                }
	            }
	            i++;
	        }
	        i--;
	        if(i==0) return "";
	        return strs[0].substring(0,i);
	    }

}
