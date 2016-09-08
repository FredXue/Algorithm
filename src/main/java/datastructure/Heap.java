package dataStructure;

public class Heap {
	 int[] array;
	 int size;
	 final int DEFAULT_CAPACITY = 20;
      public Heap(){
    	  array = new int[DEFAULT_CAPACITY+1];
    	  size=0;
      }
      
      public Heap(int size){
    	  array = new int[size+1];
    	  size=0;
      }
      
      
      public int parent(int i){
    	  return i/2;
      }
      
      public int left(int i){
    	  return i*2;
      }
      
      public int right(int i){
    	  return 2*i+1;
      }
      
     
     public void build(){
    	 for( int i = size/2; i>0; i-- )
             sink(i);
     }
     
     public void heapsort(){
    	 
     }
	
     public void insert(int i){
    	 if(isFull()){ 
    		 System.out.println("Heap overflow");
    		 return;
    	 }
    	 
    	 array[++size] = i;
    	 swim(size);
     }
     
     public void swim(int k){
    	 while(array[parent(k)]<array[k] && k>1){
    		 int temp = array[k];
    		 array[k] = array[parent(k)];
    		 array[parent(k)] = temp;
    		 k=parent(k);
    	 }
    	 return;
     }
     
     public void sink(int k){
    	 while(2*k<=size){
    		 int j=2*k;
    		 if(right(k)<=size && array[left(k)]<array[right(k)]) {
    			 j=j+1;
    		 }
    		 if(array[j]<array[k]) break;
    		 int temp = array[k];
    		 array[k] = array[j];
    		 array[j] = temp;
    		 k=j;
    	 }
     }
     
     public int getMax(){
    	 if(size>=1) return array[1];
    	 else return -1;
     }
     
     public int delMax(){
    	 if(size>=1){ 
    		 
    		 
    		 int max =array[1];
    	     array[1]=array[size];
    	     size--;
    	     sink(array[1]);
    	     return max;
    	 }
    	 else return -1;
     }
     
     public boolean isFull(){
    	return size==array.length-1;
     }
     
     public boolean isEmpty(){
    	 return size==0;
     }
     
     
	
	  
}
