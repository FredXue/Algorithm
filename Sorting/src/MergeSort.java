
public class MergeSort {

	
	
	  private static Comparable[] b;
	/**
	 * @Title main
	 * @Discription
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Integer[] test ={1,3,7,2,3,5,7,2,1,3,8,6,9,0,2};
        sort(test);
       for(Integer i:test) System.out.println(i);
	}
	
	
	   public static void merge(Comparable[] a,Comparable[] aux, int lo, int mid, int hi){
		   assert Sort.isSorted(a,lo,mid);
		   assert Sort.isSorted(a,mid+1,hi);
		   
		   for(int k=lo;k<=hi;k++)   aux[k]=a[k];
		   //Bug 1 :j=mid
		   int i=lo, j= mid+1;
		   for(int k=lo;k<=hi;k++){
	               if(i>mid)   a[k]=aux[j++];
	               else if(j>hi) a[k]=aux[i++];
	               //Bug 2 : Compare a[i] and a[j]
	               else if(Sort.less(aux[i],aux[j])) a[k]=aux[i++];
	               else  a[k]=aux[j++];
		   }
	   }

	   public static void sort(Comparable[] a , Comparable[] aux, int lo, int hi){
		   if(hi<=lo) return;
		   int mid = lo + (hi-lo)/2;
		   sort(a,aux,lo,mid);
		   sort(a,aux,mid+1,hi);
		   merge(a,aux,lo,mid,hi);
	   }
	   public static void sort(Comparable[] a){
		   b = new Comparable[a.length];
		   sort(a,b,0,a.length-1);
		   
		   
	   }
}
