package com.leetcode;

public class sort_list {
	
	
   static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
   
   	public ListNode sortList(ListNode head) {
   		return mergeSort(head);
    }
    
	public ListNode mergeSort(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		ListNode pre = null;
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		pre.next = null;
		ListNode node1 = mergeSort(head);
		ListNode node2 = mergeSort(slow);
		return merge(node1, node2);
	}
	
	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				cur.next = l1;
				l1 = l1.next;
			}else {
				cur.next = l2;
				l2 = l2.next;
			}
		}
		cur = cur.next;
		if(l1 != null){
			cur.next = l1;
		}
		if(l2 != null){
			cur.next = l2;
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		 ListNode node = new ListNode(5);
		 node.next = new ListNode(6);
		 node.next.next = new ListNode(4);
		 node.next.next.next = new ListNode(3);
		 ListNode res = new sort_list().sortList(node);
		 System.out.println(res.next.next.val);

	}

}
