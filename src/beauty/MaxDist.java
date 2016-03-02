public class MaxDist{
    public static void main(String[] args){
        
    }
    
    public Result maxDist(Node root){
        if(root == null) return new Result(-1,0);
        
        Result left = maxDist(root.left);
        Result right = maxDist(root.right);
        
        int a = Math.max(left.maxDepth, right.maxDepth) + 1;
        int b = Math.max(left.maxDepth+right.maxDepth+2, Math.max(left.maxDist,right.maxDist));
        
        return new Result(a, b);
        
    }
    
}

class Node{
    Node left;
    Node right;
}

class Result{
    int maxDepth;
    int maxDistance;
    public Result(int a, int b){
        this.maxDepth = a;
        this.maxDistance = b;
    }
}