package com.leetcode;

import java.awt.event.MouseWheelEvent;
import java.util.Stack;

public class merge_2_binary_trees {
	
	
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	
//	�����������ϲ���������������Ӧ�ڵ��ֵ��ӡ�
//	�ⷨһ�����õݹ�Ľⷨ�����ϵݹ�����������������ӽڵ㡣
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if(t1 == null){
			return t2;
		}
		if(t2 == null){
			return t1;
		}
		t1.val += t2.val;
		t1.left = mergeTrees(t1.left, t2.left);
		t1.right = mergeTrees(t1.right, t2.right);		
		return t1;				
    }
	
//	���õ��ƵĽⷨ������ջ��ÿ���ж���������Ӧ�ڵ��Ƿ���ڣ������Ӧ�ڵ�ĺ�ֵ�����ж������ڵ�����ҽڵ��Ƿ���ڣ����ڵĻ���Ӧ��ڵ�push��ջ���Ҷ�Ӧ�ҽڵ�push��ջ��
	public TreeNode mergeTrees_2(TreeNode t1, TreeNode t2) {
		
		if(t1 == null){
			return t2;
		}
		Stack<TreeNode[]> stack = new Stack<>();
		stack.push(new TreeNode[]{t1, t2});
		while (!stack.isEmpty()) {
			TreeNode[] t = stack.pop();
			if(t[0] == null || t[1] == null){
				continue;
			}
			
			t[0].val += t[1].val;
			if(t[0].left == null){
				t[0].left = t[1].left;
			}else {
				stack.push(new TreeNode[]{t[0].left, t[1].left});
			}
			
			if(t[0].right == null){
				t[0].right = t[1].right;
			}else {
				stack.push(new TreeNode[]{t[0].right, t[1].right});
			}		
		}
		return t1;
		
	}
	
	
	
	public static void main(String[] args) {
		 TreeNode root1 = new TreeNode(1);
		 root1.left = new TreeNode(2);
		 root1.right = new TreeNode(3);
		 root1.left.left = new TreeNode(4);
		 root1.left.right = new TreeNode(5);
		 root1.right = new TreeNode(3);
		 	
		 
		 TreeNode root2 = new TreeNode(5);
		 root2.left = new TreeNode(3);
		 root2.right = new TreeNode(6);
		 root2.left.left = new TreeNode(2);
		 root2.right.left = new TreeNode(1);
		 root2.right.right = new TreeNode(4);
		 
		 System.out.println(new merge_2_binary_trees().mergeTrees(root1, root2).val);
		 System.out.println(new merge_2_binary_trees().mergeTrees_2(root1, root2).val);
	}

}
