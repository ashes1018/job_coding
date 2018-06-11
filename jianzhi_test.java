package com.leetcode;

import java.nio.channels.NonWritableChannelException;

public class jianzhi_test {
	
	static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k< 0){
            return null;
        }
        ListNode node1 = head;
        ListNode node2 = head;
        int count = 0;
        while(node2.next != null && count < k){
            node2 = node2.next;            
            count +=1;
        }
        
        while(node2.next != null){
            node2 = node2.next;
            node1 = node1.next;            
        }
        return node1;
    }
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);
		int k =1;
		ListNode node1 = new jianzhi_test().FindKthToTail(node, 1);
		System.out.println(node1.nextval);
 	

	}
}
 
