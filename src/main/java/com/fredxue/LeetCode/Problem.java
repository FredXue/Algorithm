package com.fredxue.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;


public class Problem {
	public static void main(String[] args) {
     int[] num = {88, 459, 5262, 88, -17, 677, 88, 667, -17, 459, 5262};
		
		System.out.println(new Problem().triple(num));
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
	    
	    public List<List<Integer>>  threesum(int[] num){
	    	// 3-sum �ܽ� ��˫ָ�뷨
	    	 List<List<Integer>> result = new ArrayList<List<Integer>>();
	         if(num.length<3) return result;
	         Arrays.sort(num);

	         for(int i=0;i<num.length-2;i++){
	             if(i==0 || num[i]>num[i-1]){
	                 int left =i+1;
	                 int right = num.length-1;
	                 int negate = 0-num[i];
	                 while(left<right ){
	                     List<Integer> temp = new ArrayList<Integer>();
	                     if((num[right]+num[left])==negate){
	                         temp.add(num[i]);
	                         temp.add(num[left]);
	                         temp.add(num[right]);
	                         result.add(temp);
	                         
	                         left++;
	                         right--;
	                         
	                         while( left<right &&  num[left]==num[left-1]) left++;
	                         while(left<right && num[right]== num[right+1]) right--;
	                     }else if((num[right]+num[left])>negate){
	                         right--;
	                     }else{
	                        left++;
	                     }
	                 }
	             }
	         }
	         return result;
	    
	    }
	    
	
	        public int threeSumClosest(int[] nums, int target) {
	            int min = Integer.MAX_VALUE;
	            Arrays.sort(nums);
	         int result = 0;
	         
	         for(int i=0;i<nums.length-2;i++){
	             int j = i+1;
	             int k= nums.length-1;
	             while (j < k) {
	    			int sum = nums[i] + nums[j] + nums[k];
	    			int diff = Math.abs(sum - target);
	     
	    			if(diff == 0) return sum;
	     
	    			if (diff < min) {
	    				min = diff;
	    				result = sum;
	    			}
	    			if (sum <= target) {
	    				j++;
	    			} else {
	    				k--;
	    			}
	             }
	         
	         }
	         
	         return result;

	        }
	        

	        public List<List<Integer>> fourSum(int[] nums, int target) {
	            List<List<Integer>> result = new ArrayList<List<Integer>>();
	            if(nums.length<4) return result;
	            Arrays.sort(nums);
            // Use HashSet to avoid duplicate element.
	            for(int i=0;i<nums.length-3;i++){
	                if(i>0 && nums[i-1]==nums[i]) continue;
	                for(int j=i+1;j<nums.length-2;j++){
	                       if(j>i+1 && nums[j-1]==nums[j]) continue; // avoid duplicate
	                               int start =j+1;
	                              int end = nums.length-1;
	                  while(start<end){
	                    if((nums[i]+nums[j]+nums[start]+nums[end])==target){
	                        List<Integer> temp = new ArrayList<Integer>();
	                        temp.add(nums[i]);
	                         temp.add(nums[j]);
	                          temp.add(nums[start]);
	                           temp.add(nums[end]);
	                           result.add(temp);
	                           
	                           start++;
	                           end--;
	                           while(start<end && nums[start]==nums[start-1]) start++;
	                           
	                           while(start<end && nums[end]==nums[end+1]) end--;
	                    }else if ((nums[i]+nums[j]+nums[start]+nums[end])>target){
	                        end--;
	                    }else start++;
	                    
	                  }
	                }
	            }
	            
	            return result;
	        }
	        

	//=======================================================================================          

     HashMap<Integer,String> map = new HashMap<Integer,String>();
    public List<String> letterCombinations(String digits) {
       
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        map.put(0,"");
        List<String> result = new ArrayList<String>();
        if(digits.length()<1 || digits==null){
            return result;
        }
        ArrayList<Character> temp = new ArrayList<Character>();
        getString(digits,temp,result);
        
        return result;
        
    }
    
    public void getString(String digits,List<Character> temp, List<String> result){
        if(digits.length()<1){
            char[] n = new char[temp.size()];
            for(int i=0;i<temp.size();i++){
                n[i] = temp.get(i);
            }
            String s = String.valueOf(n);
            result.add(s);
            return;
        }
        
        Integer num = Integer.valueOf(digits.substring(0,1));
        digits = digits.substring(1);
        for(char c: map.get(num).toCharArray()){
            temp.add(c);
            getString(digits,temp,result);
            temp.remove(temp.size()-1);  // This is important!
        }
    
   }
 
    //=======================================================================
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return null;
        
        ListNode front = head;
        ListNode back = head;
        while(n>0){
            front = front.next;
            n--;
        }
        
        if(front == null){
             head = head.next;
             return head;
        }
        
        while(front.next!=null){
            front = front.next;
            back = back.next;
        }
        ListNode d = back.next;
        back.next = back.next.next;
        d.next = null;
        
        
        return head;
    }
    
    
    public boolean isValid(String s) {
    	if(s==null || s.length()<1) return false;
    	
        Stack<Character> stack = new Stack<Character>();
      
    	
        for(int i=0;i<s.length();i++){
        	switch(s.charAt(i)){
        	case '{':{
        		stack.push('{');
        		break;
        	}
        	case '}':{
        	    if(stack.isEmpty()) return false;
        	    Character c = stack.pop();
        	    if(c == null || !c.equals('{') ) return false;
        		break;
        	}
        	case '[':{
        		stack.push('[');
        		break;
        	}
        	case ']':{
        		   if(stack.isEmpty()) return false;
        		   Character c = stack.pop();
           	    if(c == null || !c.equals('[') ) return false;
        		break;
        	}
        	case '(':
        	{
        		stack.push('(');
        		break;
        	}
        	case ')':{
        		   if(stack.isEmpty()) return false;
        		   Character c = stack.pop();
           	    if(c == null || !c.equals('(') ) return false;
        		break;
        	}
        		
        	}
        }
      
    	if(!stack.isEmpty()) return false;
        return true;
        
       }
    
  //==========================================================
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        dfs(result,"",n,n);
        return result;
    }
    
    
    public void dfs(List<String> list,String s, int left, int right){
        if(left==0 && right==0) {
            list.add(s);
            return;
        }
        if(left>right) return;
        
        if(left>0) dfs(list,s+'(',left-1,right);
        if(right>0) dfs(list,s+')',left,right-1);
    }
    
    public int triple(int[] nums){
    	if(nums==null || nums.length<1) return Integer.MAX_VALUE;
    	  Arrays.sort(nums);
    	  int a =nums[0];
    	  for(int i =2;i<nums.length;i=i+2){
    		  if(nums[i]==a) return a;
    		  a =nums[i];
    	  }
    	  
    	  return Integer.MAX_VALUE;
    	 
    	}
    
    
    //======================================================================
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>();
        ListNode result;
        if(lists==null || lists.length<1) return null;
        
       
        return lists[0];
    }
    
    
    class SizeComparator  implements Comparator<ListNode>{
    	public int compare(ListNode l1,ListNode l2){
    		if(l1.val>l2.val) return 1;
    		else if(l1.val==l2.val) return 0;
    		else return -1;
    	}
    }
    
    
    
    //===============================================================================
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head ==null || head.next==null) return head;
        if(k<=1) return head;
        
        int len = getLength(head);
        if(len/k==0) return head;
        ListNode preTail = null;
        ListNode current = head;
        ListNode res =null;
        
        while(getLength(current)>=k){
            if(preTail==null) {
                res =  reverse(current,k);
            }else{
                preTail.next = reverse(current,k);
            }
          
            preTail = current;
            current= current.next;
            if(current==null) break;
        }
        
        return res;
        
    }
    
    public ListNode reverse(ListNode head,int k){
       //reverse a list and return the new head;
        ListNode pre,cur,nex;
        pre = head;
        cur = head.next;
        if(k==2){
           pre.next=cur.next;
           cur.next=pre;
           return cur;
        }else{
            nex=cur.next;
            while(k>1){
                k--;
                cur.next=pre;
                pre=cur;
                cur=nex;
                if(nex!=null) nex=nex.next;
            }
            head.next=cur;
            return pre;
        }

        
    }
    
    public int getLength(ListNode node){
        int l=0;
        if(node==null) return l;
       
        while(node!=null){
            node = node.next;
            l++;
        }
        return l;
    }
     
    
    



}
