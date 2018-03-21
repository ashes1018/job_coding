package com.leetcode;

public class LInked_List_Cycle_II {
	
	static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
		 val = x;
		 next = null;
		 	}
	}
//  这道题的解法，就是在判断是否有环的基础上，找出两个指针的相遇点，然后设置fast指针在相遇点继续走，slow指针回到开始走，速度设为一样，这样子再次相遇的就是所求的点。
	public ListNode detectCycle(ListNode head) {		
		ListNode fast = head;
		ListNode slow = head.next;
		if(fast == null || fast.next == null){
			return null;
			}
		while (fast != slow) {
			if(fast == null || fast.next == null){
				return null;
				}
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow){
				break;
			}
			}
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
		}
     
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = node.next;
		System.out.println(new LInked_List_Cycle_II().detectCycle(node).val);
		 
	}

}
