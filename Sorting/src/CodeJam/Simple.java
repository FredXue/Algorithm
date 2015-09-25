package CodeJam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
	      String s = in.next();
	      if(isP(s)) {
	    	  System.out.println("YES");
	    	  return;
	      }
	      for(int i=0;i<s.length();i++){
	    	  String newString =s.substring(1);
	    	  if(i>0) newString =  s.substring(0,i)+s.substring(i+1);
	    	  if(isP(newString))     { System.out.println("YES");
	    	  return;
	    	  }
	      }
	      System.out.println("NO");
		 }
		 
		 boolean isP(String s){
			 for(int i=0;i<s.length()/2;i++){
				 if(s.charAt(i)!=s.charAt(s.length()-i-1)) return false;
			 }
			 return true;
		 }
	 
	 
	
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
