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

public class StringMatchContent {
     FastScanner in;
     PrintWriter out;

	 
	 void run(){
			 in = new FastScanner(System.in);
			 out = new PrintWriter(System.out);
			 
			 solve();
			 
			 out.close();		 
	 }
	 
	 void solve(){
	      String a  = in.next();
	      String b = in.next();
	      int m = a.length();
	      int n = b.length();
	      int dp[][] = new int[m+1][n+1];
	      int f[][] = new int[m+1][n+1];
	      int dp1[][] = new int[m+1][n+1]; //record the split way
	      
	      //preprocess to handle the subsed must longer than 3.
	      for(int i=1;i<=m;i++){
	    	  for(int j=1;j<=n;j++){
	    		  if(a.charAt(i-1)==b.charAt(j-1))  f[i][j] = f[i-1][j-1]+1;
	    		  else f[i][j] = 0;
	    	  }
	      }
	      //memorize the subproblem.
	      for(int i=1;i<=m;i++){
	    	  for(int j=1;j<=n;j++){
	    		if(f[i][j]>=3) dp1[i][j] = dp[i-3][j-3]+3;  
	    		
	    		if(f[i][j]>3)  dp1[i][j] = Math.max(dp1[i][j], dp1[i-1][j-1]+1);
	    		
	    		dp[i][j] =  Math.max(dp[i-1][j],dp[i][j-1]);
	    		dp[i][j] = Math.max(dp1[i][j], dp[i][j]);
	    	  }
	      }
	      
	      
	      System.out.println(dp[m][n]);
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
			new StringMatchContent().run();
		}
}
