package com.fredxue.codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HamitonianCycle {
     FastScanner in;
     PrintWriter out;

	 
	 void run(){
			 in = new FastScanner(System.in);
			 out = new PrintWriter(System.out);
			 
			 solve();
			 
			 out.close();		 
	 }
	 int count =0;
	 int edge[];
	 int map[];
	 void solve(){
	         int vertex = in.nextInt();
	         int m= in.nextInt();
	         
	         edge = new int[vertex];
	         map = new int[1<<vertex];
	         
	         for(int i=0;i<vertex;i++){
	        	 map[1<<i] = i+1; 
	         }
	         while(m-->0){
	        	 int u = in.nextInt();
	        	 int v = in.nextInt();
	        	 edge[u-1]  = edge[u-1] | 1<<v; //record edges
	         }
	         
	         dfs(1,1<<vertex-2);
	         
	         System.out.println(count);
		 }
	 
	 public void dfs(int v,int unvisited){
		 if(unvisited==0 && (edge[v] & 1)>0) count++;
		 int rest = unvisited & edge[v];
		 while(rest>0){
			  int tp = rest & (-rest);
			  dfs(map[tp],unvisited - tp );
			  rest = rest -tp;
		 }
		 return;
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
			new HamitonianCycle().run();
		}
}
