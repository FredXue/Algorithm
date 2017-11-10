package com.fredxue.LeetCode;

public class StringMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] a = new StringMatch().computePa("aab");
       for(int x: a){
    	   System.out.println(x);
       }
	}
	
	public int naiveMatch(String text, String p){

		return 0;
	}
	
	
	public int KMPMatch(String text, String p){
		int n =text.length();
		int m = p.length();
		int[] pa = computePa(p);
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(text.charAt(i+j)!=p.charAt(j)){
					i=i+pa[j];
					break;
				}
				if(j==m-1 && text.charAt(i+j)==p.charAt(j)) return i;
			}
		}
//		a different angle to match the string.
//		int q=0;
//		for(int i=0;i<n;i++){
// 			for(int j=0;j<m;j++){
// 				if(haystack.charAt(i+j)!=needle.charAt(j)){
// 					i=i+pa[j];
// 					break;
// 				}
// 				if(j==m-1 && haystack.charAt(i+j)==needle.charAt(j)) return i;
// 			}
//
//            while(q>0 && haystack.charAt(i)!=needle.charAt(q))  q=pa[q-1];
//            
//            if(haystack.charAt(i)==needle.charAt(q)) q++;
//            
//            if(q==m) return i-m+1;
//		}
		return -1;
	}
	
	
	
	public int[] computePa(String p){
		int[] a = new int[p.length()];
		int k =0;
		a[0] =0;
		for(int i=1;i<p.length();i++){
			while(k>0 && p.charAt(i)!=p.charAt(k))  k =a[k-1];
			
			if(p.charAt(i)==p.charAt(k))   k++;
			a[i] = k;
		}
		
		return a;
	}

}
