package CodeJam;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;



public class MSPractice {
    public static void main(String[] args){       
    	
    }
    
    //========================================================================
    public void BrowsingCache(){
    	Scanner sc = new Scanner(System.in);
    	int hitCount = sc.nextInt();
    	int cacheSize = sc.nextInt();
    	for(int i = 0;i<hitCount;i++){
    		String url = sc.nextLine();
    		
    	}
    }
}

class Container{
	 TreeMap<String,Integer> m = new TreeMap<String,Integer>(new ValueComparator());
	 int count = 0;
	 final int MAX_SIZE;
	 public Container(int size){
		 MAX_SIZE=size;
	 }
	 
	 public boolean isFull(){
		 return true;
	 }
	 
	 public String hit(){
		 return "d";
	 }
	 
	 static class ValueComparator implements Comparator<String>{
		 Map<String,Integer> basemap;

         @Override
         public int compare(String a,String b){
        	 
        	 return 0;
         }
	 }
	 

}
