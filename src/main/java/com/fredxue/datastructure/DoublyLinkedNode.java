package com.fredxue.datastructure;

/**
 * Created by fredxue on 29/11/2017.
 */
public class DoublyLinkedNode {
    public int val;
    public DoublyLinkedNode prev;
    public DoublyLinkedNode next;
    public DoublyLinkedNode(int v) {
        this.val = v;
    }

    public static void print(DoublyLinkedNode head) {
        if(head == null) System.out.println("NUll");
        else {
            DoublyLinkedNode node = head.next;
            System.out.print(head.val + "->");
            while (node != head && node !=null) {
                System.out.print(node.val + "->");
                node = node.next;
            }
        }
    }

}
