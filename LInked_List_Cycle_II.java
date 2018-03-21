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
//  �����Ľⷨ���������ж��Ƿ��л��Ļ����ϣ��ҳ�����ָ��������㣬Ȼ������fastָ��������������ߣ�slowָ��ص���ʼ�ߣ��ٶ���Ϊһ�����������ٴ������ľ�������ĵ㡣
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
