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
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
     FastScanner in;
     PrintWriter out;

	 
	 void run(){
			 in = new FastScanner(System.in);
			 out = new PrintWriter(System.out);
			 
			 solve();
			 
			 out.close();		 
	 }
	 
	 void solve(){
		 Scanner scanner = new Scanner(System.in);
		 String input = scanner.nextLine();
		 String[] r = input.split(";");
		 int row = r.length;
		 int col = r[0].split(" ").length-1;
		 int[][] matrix = new int[row][col];
         for(int i=0;i<row;i++){
        	 String[] temp = r[i].split(" ");

        	 for(int j=0;j<col;j++){
        		 if(i==0) matrix[i][j] = Integer.parseInt(temp[j+1]);
        		 else matrix[i][j] = Integer.parseInt(temp[j+1]);
        	 }
         }
         
         int max=Integer.MIN_VALUE;
         for(int i=0;i<row-1;i++){
        	 for(int j=0;j<col-1;j++){

        		 int sum = matrix[i][j]+matrix[i+1][j]+matrix[i][j+1]+matrix[i+1][j+1];
        		 if(sum>max) max= sum;
        	 }
         }
         scanner.close();
         System.out.println(max);

	     
	
	
       
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
			new Main().run();
		}
}
