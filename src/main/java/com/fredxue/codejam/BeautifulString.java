package com.fredxue.codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;


public class BeautifulString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            new BeautifulString().run();
	}
	
	 FastScanner in;
     PrintWriter out;

	 
	 void run(){
			 in = new FastScanner(System.in);
			 out = new PrintWriter(System.out);
			 
			 solve();
			 
			 out.close();		 
	 }
	 
	 void solve(){
		 int tc = in.nextInt();
		 for(int i=0;i<tc;i++){
			 int len = in.nextInt();
			 String s = in.next();
			 List<data> list = new ArrayList<data>();
			 for(int j=0;j<len;j++){
				 int count =1;
				 if(j+1<len && s.charAt(j)==s.charAt(j+1)) count++;
				 else{
				
					 list.add(new data(s.charAt(j),count));
				 }
			 }
			 boolean flag=true;
			 if(list.size()<3) {System.out.println("NO"); continue;}
			 for(int j=0;j<list.size()-2;j++){
				 if(list.get(j).a==(list.get(j+1).a-1) && list.get(j).a==(list.get(j+2).a-2) &&
						 list.get(j).len>=list.get(j+1).len && list.get(j+2).len>=list.get(j+1).len)
				 {
					 System.out.println("YES"); 
				 flag=false;
				 break;}
			 }
			if(flag) System.out.println("NO");

		 }
	 }
	 
	 class data{
		 int a;
		 int len;
		 data(char ab,int l){
			 a=(int)ab;
			 len=l;
		 }
	 }
	 
//	 void solve(){
//		int tc = in.nextInt();
//		data[] log = new data[tc];
//		Stack<data> stack = new Stack<data>();
//		List<data> list = new ArrayList<data>();
//		for(int i=0;i<tc;i++){
//			String f = in.next();
//			String time  = in.next();
//			String action = in.next();
//            log[i] = new data(f,time,action);
//		}
//		for(int i=0;i<tc;i++){
//			if(i>0 && log[i].time<log[i-1].time) {System.out.println("Incorrect performance log");
//			  return;
//			}
//			if(log[i].action.equals("START")){ stack.push(log[i]);
//			  list.add(log[i]);
//			}
//			else{
//				if(!stack.peek().func.equals(log[i].func)  || stack.peek().time>log[i].time ){
//				  System.out.println("Incorrect performance log");
//				  return;
//				}else{
//					data d = stack.pop();
//					d.time = log[i].time-d.time;
//				}
//			}
//		}
//		if(!stack.isEmpty()) {System.out.println("Incorrect performance log");
//		return ;
//		}
//		
//		for(data d:list){
//			System.out.println(d.func+" "+intToTime(d.time));
//		}
//	 }
//	 
//	 class data{
//		 String func;
//		 int time;
//		 String action;
//		 data(String f, String t,String a){
//			 func =f;
//			 time = timeToint(t);
//			 action = a;
//		 }
//	 }
	 
	 static int timeToint(String time){
		 String[] str = time.split(":");
		 return Integer.valueOf(str[0])*3600+Integer.valueOf(str[1])*60+Integer.valueOf(str[2]);
	 }
	 
	 static String intToTime(int time){
		 DecimalFormat df  = new DecimalFormat("00");
		int h = time/3600;
		int m = time%3600/60;
		int s = time%60;
		return df.format(h)+":"+df.format(m)+":"+df.format(s);
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

}
