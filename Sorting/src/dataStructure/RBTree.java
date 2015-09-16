package dataStructure;



/**
 * @ClassName RBTree
 * @Discription  left-leaning BST 
 * @author Fred Xue
 * @Date 2015年9月16日
 * 
 * No node has two red links connected to it
 * Every path from root to null link has same number of black links
 * red links lean left
 * 
 * There is a 1-1 correspondence between RBT and 2-3T
 */



public class RBTree {
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
    private class Node{
    	private int key;
    	private int val;
    	private Node left,right;
    	boolean color; // color of parent link
    	public Node(int k,int v){
    		key =k;
    		val = v;
    	}
    }
    
    private boolean isRed(Node x){
    	if(x==null) return BLACK;
    	return x.color==RED;
    }
    
    private Node rightRotation(Node x){
    	
    }
    
    private Node leftRotation(Node x){
    	
    }
    
    private void flipColor(Node x){
    	
    }

}
