package com.fredxue.interview;

import com.fredxue.LeetCode.ListNode;
import com.fredxue.datastructure.BinaryTreeNode;
import com.fredxue.datastructure.DoublyLinkedNode;
import com.fredxue.interview.facebook.BSTToLinkedList;
import org.apache.htrace.fasterxml.jackson.core.TreeNode;
import org.apache.htrace.fasterxml.jackson.databind.node.BigIntegerNode;
import org.junit.Test;

/**
 * Created by fredxue on 29/11/2017.
 */
public class TestBSTToList {

    @Test
    public void testConvertTree(){
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(4);
        root.right = new BinaryTreeNode(11);
        root.left.left = new BinaryTreeNode( 3);
        root.left.left.left = new BinaryTreeNode( 0);
        root.right.left = new BinaryTreeNode(9);
        DoublyLinkedNode head = BSTToLinkedList.convertToList(root);
        DoublyLinkedNode.print(head);
    }

}
