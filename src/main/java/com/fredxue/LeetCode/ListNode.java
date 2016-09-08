package com.fredxue.LeetCode;



public class ListNode {
//	
    int val;
    ListNode next;
    ListNode(int x) { val = x; }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int d =0;
        int a =0;//进位
        ListNode res= new ListNode(-1);
        ListNode cur = res;
        
        ListNode temp = null;
        while(l1!=null || l2!=null){
        	if(l1==null && l2!=null){
        		d = (l2.val+a)%10;
        		a = (l2.val+a)/10;  
        		l2=l2.next;
        	}else if(l2==null && l1!=null){
        		d = (l1.val+a)%10;
        		a = (l1.val+a)/10; 
        		 l1=l1.next;
        	}else{     		
        		d = (l1.val+l2.val+a)%10;
        		a = (l1.val+l2.val+a)/10;
        		l1=l1.next;
                l2=l2.next;
        	}
         
               temp = new ListNode(d);           
               cur.next = temp;
               cur=cur.next;
           
            
        }
        if(a!=0) {
        	temp = new ListNode(a);
        	cur.next = temp;
        }

    return res.next;
    }
}
