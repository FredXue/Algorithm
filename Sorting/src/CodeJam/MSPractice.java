package codeJam;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;



public class MSPractice {
    public static void main(String[] args){    
    	new MSPractice().BrowsingCache();
    }
    
    //========================================================================
    public void BrowsingCache(){
    	Scanner sc = new Scanner(System.in);
    	int hitCount = sc.nextInt();
    	int cacheSize = sc.nextInt();
    	sc.nextLine();
    	HashMap<String,Integer> map = new HashMap<String,Integer>();
    	for(int i = 0;i<hitCount;i++){
    		String url = sc.nextLine();
    		if(!map.containsKey(url) ){
    			System.out.println("Internet");
    			map.put(url, i);
    			if(map.size()>cacheSize)  delLast(map);
    			
    		}else{
    			System.out.println("Cache");
    			map.put(url, i);
    		}
    	}
    }
    
    public void delLast(HashMap<String,Integer> m){
    	int i = Integer.MAX_VALUE;
    	String k=null;
    	for(Entry e: m.entrySet()){
    		if((Integer)e.getValue()<i){ k =(String) e.getKey();
    		i=(Integer)e.getValue();
    		}
    	}
    	m.remove(k, i);
    }
}


	 

