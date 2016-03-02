import java.util.ArrayList;

public class Rebuild{
    /**
     *用前序和中序结果重建二叉树，并输出后序遍历结果 
     **/
    
    public static Node buildTree(char[] preOrder, int start,  
            char[] inOrder, int end, int length) {  
        //参数验证  
        if (preOrder == null || preOrder.length == 0 || inOrder == null  
                || inOrder.length == 0 || length <= 0) {  
            return null;  
        }  
          
        //建立子树根节点  
        char value = preOrder[start];  
        Node root = new Node();  
        root.value = value;  
        
        System.out.println(value);
          
        //递归终止条件：子树只有一个节点  
        if (length == 1)  
            return root;  
          
        //分拆子树的左子树和右子树  
        int i = 0;  
        while (i < length) {  
            if (value == inOrder[end - i]) {  
                break;  
            }  
            i++;  
        }  
          
        root.right = buildTree(preOrder, start + length - i, inOrder, end, i );  
        //建立子树的左子树  
        root.left = buildTree(preOrder, start + 1, inOrder, end - i - 1, length - 1 - i);  
        //建立子树的右子树  
          
        return root;  
    }  
    
     public static void main(String[] args) {  
        char[] preOrder = new char[] {'a', 'b', 'd', 'c', 'e', 'f'};  
        char[] inOrder = new char[] {'d', 'b', 'a', 'e', 'c', 'f'};  
        Node root = buildTree(preOrder, 0, inOrder, inOrder.length - 1, inOrder.length);  
    }  
    
    
}

class Node{
    Node left;
    Node right;
    char value;
}