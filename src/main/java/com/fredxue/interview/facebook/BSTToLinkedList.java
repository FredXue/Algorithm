package com.fredxue.interview.facebook;

import com.fredxue.datastructure.BinaryTreeNode;
import com.fredxue.datastructure.DoublyLinkedNode;

/**
 * Created by fredxue on 29/11/2017.
 */
public class BSTToLinkedList {
    public static DoublyLinkedNode convertToList(BinaryTreeNode root) {
        if(root == null) return null;
        DoublyLinkedNode dummyHead = new DoublyLinkedNode(0);
        dummyHead.next = dummyHead;
        dummyHead.prev = dummyHead;
        convert(root, dummyHead);
        dummyHead.prev.next = dummyHead.next;
        dummyHead.next.prev = dummyHead.prev;
        DoublyLinkedNode head = dummyHead.next;
        dummyHead.next = null;
        dummyHead.prev = null;
        return head;
    }

    public static void convert(BinaryTreeNode root, DoublyLinkedNode head) {
        if(root == null) return;
        DoublyLinkedNode node = addAfterHead(head, root.val);
        convert(root.left, head);
        convert(root.right, node);
    }

    public static DoublyLinkedNode addAfterHead(DoublyLinkedNode head, int val) {
        DoublyLinkedNode node = new DoublyLinkedNode(val);
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
        return node;
    }

}


