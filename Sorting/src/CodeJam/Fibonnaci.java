package CodeJam;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import CodeJam.Main.FastScanner;

public class Fibonnaci {
    FastScanner in;
    PrintWriter out;
    
	 List<Integer> feib = new ArrayList<Integer>();
	 
   public void run(){
		 int n = in.nextInt();		
		 
	 feib.add(1);
	 int a1=1;
	 int a2=1;
	 for(int i=0;i<30;i++) {
		 int temp = a1+a2;
		 feib.add(temp);
		 a1=a2;
		 a2=temp;
	 }

   long[] dp = new long[25];
   int first = in.nextInt();
   if(first==1) dp[0]=1;
	 for(int i =1;i<n;i++){ 
		 int x = in.nextInt();

       if(x==1){ 
  	 dp[1]=dp[0]+dp[1];
  	 dp[0]++;
       }
  	 int index = feib.indexOf(x);

		 if(index>0 && index<=i){
			 index++;		 
			 dp[index] = dp[index]+dp[index-1];
		 }
	 }
	 
	 long result =0;
	 for(int i=0;i<25;i++){
		 result = result+dp[i];
	 }
	System.out.println(result%1000000007);
   }
}
