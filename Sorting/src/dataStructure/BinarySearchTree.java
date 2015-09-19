package dataStructure;

/**
 * @ClassName BinarySearchTree
 * @Discription    use BST implement a  symbol table
 * @author Fred Xue
 * @Date 2015年9月16日
 */


/**
 * 2-3 tree  definition 
 * allow 1 or 2 keys per node
 * every path from root to null link has same length
 * 
 */
public class BinarySearchTree {
    private Node root;
    
    private class Node{
    	private int key;
    	private int val;
    	private Node left,right;
    	public Node(int k,int v){
    		key =k;
    		val = v;
    	}
    }
    
    public void put(int key, int val){
    	
    }
    
    public void delete (int key){
    	
    }
    
    public int get(int key){
    	return -1;
    }
    
   
}



