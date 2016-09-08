package com.fredxue.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class practice816 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		Scanner s = new Scanner(System.in);
      Scanner s = new Scanner(new BufferedReader(new FileReader("E:\\Job\\Google\\8.23\\A-large.in")));
	  BufferedWriter bw=new BufferedWriter(new FileWriter("E:\\Job\\Google\\8.23\\A-large.out"));
	  int testcase= Integer.valueOf(s.nextLine());
     //template end....................

	
	  BigInteger index ;
	  String temp ="";
	     for(int i=1;i<=testcase;i++){
		 
		 index = new BigInteger(s.nextLine());
		 temp = "Case #"+i+": "+ getAnswer(index);
		 bw.write(temp);
		 bw.newLine();
	 }
	  s.close();
	  bw.close();
	
	}
	
	

	public static String getAnswer(BigInteger index){
		if(index.compareTo(new BigInteger("1"))==0) return "0";
		if(index.compareTo(new BigInteger("3"))==0) return "1";
		if(index.mod(new BigInteger("2")).compareTo(new BigInteger("0"))==0) return getAnswer(index.divide(new BigInteger("2")));
		else {
			if(index.divide(new BigInteger("2")).mod(new BigInteger("2")).compareTo(new BigInteger("0"))==0) return "0"; 
			else return "1";
		}
	
	}
	

	
	
	

}
