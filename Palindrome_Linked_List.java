package com.leetcode;

import java.util.Stack;

public class Palindrome_Linked_List {

	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	
	public boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null){
			return true;
		}
		Stack<Integer> stack = new Stack<>();
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next!= null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			stack.push(slow.val);						
		}
//		当链表长度为奇数时，需要从栈中pop出最中间的那个节点。空间O(n)。
		if(fast.next == null) stack.pop();
		
		while (!stack.isEmpty() && slow.next != null) {
			slow = slow.next;
			int temp = stack.pop();
			if(slow.val != temp){
				return false;
			}			
		}
		return true;
		}
//	空间O(1)，找到中间位置，对后半段进行翻转。但是翻转的算法不是很清楚，需要回头重新补充
	public boolean isPalindrome2(ListNode head) {
		if(head == null || head.next == null){
            return true;
        }
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode last = slow.next;
		ListNode pre = head;
		while (last.next != null) {
			ListNode temp = last.next;
			last.next = temp.next;
			temp.next = slow.next;
			slow.next = temp;		
		}
		while (slow.next != null) {
			slow = slow.next;
			if(pre.val != slow.val)	return false;
			pre = pre.next;
		}
		return true;
	}
	
	public static void main(String[] args) {		 
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(2);
		node.next.next = new ListNode(1);
		System.out.println(new Palindrome_Linked_List().isPalindrome2(node));
	}
}
