import java.util.Scanner;

public class Relativity{
    /**
     *Calcualte the relativity of two strings. 
     **/ 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println("The relativity is:" + new Relativity().calRelate(s1,s2,0,0));
    }
    
    public int calRelate(String s1, String s2, int startIndex1, int startIndex2){
        // if(s1.length() > s2.length()) return calRelate(s2, s1, startIndex2, startIndex1);
        if(s1 == null || s2==null ) return 0;
        
        if(startIndex1 >= s1.length()){
            if(startIndex2 >= s2.length()) return 0;
            else return s2.length()-startIndex2;
        }
        
        if(startIndex2 >= s2.length()){
            if(startIndex1 >= s1.length()) return 0;
            else return s1.length()-startIndex1;
        }
        
        if(s1.charAt(startIndex1) == s2.charAt(startIndex2))
            return calRelate(s1, s2, startIndex1+1, startIndex2+1);
        else{
            
            int n1 = calRelate(s1, s2, startIndex1+1,startIndex2)+1;
            int n2 = calRelate(s1, s2, startIndex1,startIndex2+1)+1;
            int n3 = calRelate(s1, s2, startIndex1+1, startIndex2+1)+1;
            
            return Math.min(n1, Math.min(n2, n3));
        }
    }
    
}