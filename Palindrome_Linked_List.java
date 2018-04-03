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
//		��������Ϊ����ʱ����Ҫ��ջ��pop�����м���Ǹ��ڵ㡣�ռ�O(n)��
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
//	�ռ�O(1)���ҵ��м�λ�ã��Ժ��ν��з�ת�����Ƿ�ת���㷨���Ǻ��������Ҫ��ͷ���²���
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
