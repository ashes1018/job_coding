package com.leetcode;

public class Remove_Nth_Node_From_End_of_List {
	
	static class ListNode {
			int val;
		    ListNode next;
		    ListNode(int x) { val = x; }
		  }
	
//	public ListNode removeNthNode(ListNode head, int n) {
//		ListNode dummy = new ListNode(0);
//		dummy.next = head;
//		int length = 0;
//		ListNode first = dummy;
//		while(first.next != null){
//			length ++;
//			first = first.next;
//		}
//		length -= n;
//		first = dummy;
//		while(length > 0){
//			first = first.next;
//			length--;
//		}
//		first.next = first.next.next;
//		return dummy.next;
//	}
	
	public ListNode removeNthNode(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode index1 = dummy;
		ListNode index2 = dummy;	 
		int count=1;
//		while(count < n){
//			System.out.println(index2.val);
//			index2 = index2.next;
//			count++;			
//		}
//		
		for(int i =1;i<= n+1 ;i++){
            index2 = index2.next;
        }
		
		while(index2 != null){
			index1 = index1.next;
			index2 = index2.next;			
		}
		index1.next = index1.next.next;
		return dummy.next;
	}
	
	
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(0);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(7);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		
		ListNode node = new Remove_Nth_Node_From_End_of_List().removeNthNode(node1,4);
		System.out.println(node.next.next.next.val);
	}
}
