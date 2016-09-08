package com.fredxue.datastructure;

import java.util.HashMap;
import java.util.Map.Entry;

public class Dynamic {
     public static void main(String[] args){
    	 Dynamic d = new Dynamic();
    	 int[] price={0,1,5,8,9,10,17,17,20,24,30};
    	 int n=10;
    	 int[] s = new int[n+1];
    	 System.out.println(d.bottomUpCutRod(price,s,n));
    	 int k=n;
    	 while(k>0){
    		 System.out.println(s[k]);
    		 k=k-s[k];
    	 }

    		 
    	
     }
     
     public int  bottomUpCutRod(int[] price,int[] s,int n){
    	 int[] r = new int[n+1];
    	
    	 r[0]=0;
    	 for(int i=1;i<=n;i++){
    		 int q=Integer.MIN_VALUE;
    		 for(int j=1;j<=i;j++){
    			 if(q<price[j]+r[i-j]) {
    				 s[i] =j;
    				 q=price[j]+r[i-j];
    			 }
    		 }
    		 r[i]=q;
    	 }
    	 return r[n];
     }
     
     public  int topUp(int[] price, int n){
    	 int[] r = new int[n];
    	 for(int i=0;i<r.length;i++) r[i]=Integer.MIN_VALUE;
    	 
    	 return memorizedTopUp(price,  r, n);
    	
     }
     
     public int memorizedTopUp(int[] price, int[] r,int n){
    	 if(r[n]>Integer.MIN_VALUE) return r[n];
    	 if(n==0) return 0;
    	 int q=Integer.MIN_VALUE;
    	 for(int i=1;i<=n;i++){ 
    		q= Math.max(q, price[i]+memorizedTopUp(price,r,n-i));
    	 }
    	 r[n]=q;
    	 return q;
     }
}
