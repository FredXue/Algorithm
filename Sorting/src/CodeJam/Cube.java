package codeJam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Cube {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		   Scanner s = new Scanner(new BufferedReader(new FileReader("E:\\Job\\Google\\8.23\\B-large.in")));
			  BufferedWriter bw=new BufferedWriter(new FileWriter("E:\\Job\\Google\\8.23\\B-large.out"));
			  int testcase= Integer.valueOf(s.nextLine());

			  String temp ="";
			     for(int i=1;i<=testcase;i++){
				 int n = s.nextInt();
				 int m = s.nextInt();
				    double[] edges = new double[n];
				    for(int j =0;j<n;j++) edges[j] = (double)s.nextInt();
		    		temp = "Case #"+i+": ";
		    		bw.write(temp);
		    		bw.newLine();
				    	for(int k=0;k<m;k++){
				    		double vol = 1.0;
				    		int start = s.nextInt();
				    		int end = s.nextInt();
				    		for(int l=start;l<=end;l++){
				    			vol = edges[l]*vol;
				    		}
				  
				    		double edge = Math.pow(vol, 1.0/(end-start+1));
				    		 DecimalFormat df =new DecimalFormat("0.000000");
				    	   
				    	  
			
				    		temp =   df.format(edge) ;
				    		bw.write(temp);
				    		bw.newLine();
				    	}
				 
				
			 }
			  s.close();
			  bw.close();
	}

}
