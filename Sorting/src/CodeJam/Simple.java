package CodeJam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Simple {
     FastScanner in;
     PrintWriter out;

	 
	 void run(){
			 in = new FastScanner(System.in);
			 out = new PrintWriter(System.out);
			 
			 solve();
			 
			 out.close();		 
	 }
	 
	 void solve(){
		   int[] a = {0,0};
              System.out.println(countCacheMiss(1,a));
		 }
		 

		 
		 public static int countCacheMiss(int max_cache_size, int[] page_requests)
		  {
		    // INSERT YOUR CODE HERE
		      Cache c = new Cache(max_cache_size);
		      
		      int count=0;
		  
		      for(int k : page_requests){
		    	  if(!c.isHit(k)) {
		    		  count++ ;
		    		  c.put(k);
		    	  }
		      }
		      
		      return count;
		     
		  }
	 

		  
		  

//		 baidu first solution 
//       int row = in.nextInt();
//       for(int i=0;i<row;i++){
//       	int[] array = new int[12];
//       	String per = in.next();
//       	int result = 0;
//       	for(int k =0;k<12;k++){
//       		int x =0;
//       		for(int j=0;j<per.charAt(k)-'a';j++){
//       			if(array[j]==0)  x++;         			
//       			
//       		}
//       		result = result+ x*j(11-k);
//               array[per.charAt(k)-'a'] = 1;
//       	}
//       	result++;
//       	System.out.println(result);
//       }  
		 
		 
//		 Solution 2
//		 String s1 = in.next();
//		 String s2 = in.next();
//		 char[] ss1 = s1.toCharArray();
//		 char[] ss2 = s2.toCharArray();
//		 int flag =1;
//		 HashMap<Character,Integer> map = new HashMap<Character,Integer>();
//		 for(char c :ss1){
//			 if(map.containsKey(c)){
//				 map.put(c, map.get(c)+1);
//			 }else{
//				 map.put(c,1);
//			 }
//		 }
//		 
//		 for(char c: ss2){
//			 if(map.containsKey(c)){
//				 if(map.get(c)>1)  map.put(c, map.get(c)-1);
//				 else map.remove(c);
//			 }else{
//				 flag =0;
//				 break;
//			 }
//		 }
//		 
//		 System.out.println(flag);
		 

		 

//	 int j(int n){
//		 int x =1;
//		 while(n>0){
//			 x= x*n;	
//			 n--;
//		 }
//		 return x;
//	 }
		 
		 
	 
	
	 class FastScanner{
		BufferedReader br;
		StringTokenizer st;
		
		public FastScanner(File f){	
			try {
				br = new BufferedReader(new FileReader(f));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public FastScanner(InputStream is){
			br = new BufferedReader(new InputStreamReader(is));
		}
		
		String next(){
			while(st == null || !st.hasMoreTokens()){
				String s =null;
				try {
					s = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(s==null) return null;
				st = new StringTokenizer(s);
				
			}
			return st.nextToken();
		}
		
		boolean hasMoreTokens(){
			while (st == null || !st.hasMoreTokens()) {
				String s = null;
				try {
					s = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (s == null)
					return false;
				st = new StringTokenizer(s);
			}
			return true;
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
	 
	 
	 
	 public static void main(String[] args) {
			new Simple().run();
		}
}


class Cache{
	
	 int point;
	 int currentSize;
	 int[] cache;
	 public Cache(int n){
		 cache = new int[n];
		 currentSize = 0;
		 point = 0;
	 }
	 
	 public void put(int n){
		 if(isFull()){ cache[point]=n;
		    point= point==cache.length-1 ? 0 : point+1;
		 }else{
			 cache[currentSize] = n;
			 currentSize++;
		 }
	 }
	 public boolean isFull(){
		 return currentSize==cache.length;
	 }
	 
	 
	 public boolean isHit(int n){
		 for(int i=0;i<currentSize;i++){
			 if(cache[i]==n) return true;
		 }
		 return false;
	 }
	 
	
}
