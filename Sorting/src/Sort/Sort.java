package Sort;


public class Sort {
	
	
	
   public static void main(String[] args){
	   
   }
   
   
   public static void selectionSort(Comparable[] a){
	   int N = a.length;
	   for(int i=0;i<N;i++){
		   int min=i;
		   for(int j=i;j<N;j++){
			   if(less(a[j],a[min]))  min=j;
		   }
		   exch(a,i,min);
	   }
	   
   }
   
   public static void insertionSort(Comparable[] a){
	    int N = a.length;
	    for(int i=0;i<N;i++){
	    	for(int j=i;j>0;j--){
	    		if(less(a[j],a[j-1])) exch(a,j,j-1);
	    		else break;
	    	}
	    }
   }
   public static void shellSort(Comparable[] a){
	   int N=a.length;
	   //use 3x+1 increment sequence
	   int h=1;
	   while(h<N/3) h=3*h+1;
	   
	   while(h>=1){
		   
		   for(int i=0;i<h;i++){
			   for(int j=i;j>=h && less(a[j],a[j-h]);j-=h){
			         exch(a,j,j-h);
			   }
		   }
		   h=h/3;
	   }
   }
   
   

   
   
   public static boolean less(Comparable v, Comparable w){
	   return v.compareTo(w)<0;
   }
   public static void exch(Comparable[] a, int n,int m){
	   Comparable swap=a[n];
	   a[n]=a[m];
	   a[m]=swap;
   }
   
   public static boolean isSorted(Comparable[] a,int lo,int hi){
	   boolean result = true;
	   for(int i =lo;lo<=hi;lo++){
		   if(less(a[i+1],a[i])) result=false;
	   }
	   
	   return result;
   }
}
