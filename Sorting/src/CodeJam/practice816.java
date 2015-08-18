package CodeJam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class practice816 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
      Scanner s = new Scanner(new BufferedReader(new FileReader("E:\\Internship\\Google\\C-small-1-attempt3.in")));
//	  File output = new File("E:\\Internship\\Google\\C-small-1-attempt0.out");
//	  FileOutputStream out = new FileOutputStream(new File("E:\\Internship\\Google\\C-small-1-attempt0.out"));  
	  BufferedWriter bw=new BufferedWriter(new FileWriter("E:\\Internship\\Google\\C-small-1-attempt3.out"));
	  int num = Integer.valueOf(s.nextLine());
	  int size = 0;
	  int ans = 0;
	  String temp ="";
	  while(num-->0){
		 size = Integer.valueOf(s.nextLine());
		 String[] v = new String[size];
		 for(int i=0;i<size;i++){
			 v[i] = s.nextLine();
		 }
		 String insert ="";
          for(int i=1;i<size;i++){
        	  insert = v[i];
        	  int j=i-1;
        	
        	  while(j>=0 && insert.compareTo(v[j])<0){
        		  v[j+1] = v[j];
        		  j--;
        	  }
        	  if(j+1 != i) ans++;
        	  v[j+1] =insert;
		 }
		 temp = "Case #"+(100-num)+": "+ ans;
		 bw.write(temp);
		 bw.newLine();
	  }
	  s.close();
	  bw.close();
	
	}
	
	

}
