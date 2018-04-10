package com.leetcode;

public class house_robber_III {
	
	static class TreeNode {
		   int val;
		   TreeNode left;
		   TreeNode right;
		   TreeNode(int x) { val = x; }
	}
	
//	递归解法。主要的策略是对一个节点node，比较node.val+rob(root.left.left)+rob(root.left.right)和rob(root.left)+rob(root.right)的值大小。
	public int rob(TreeNode root) {
		if(root == null){
			return 0;
		}
		int rootval = root.val;
		int leftHand = 0,rightHand = 0;				
		if(root.left != null){
			int left_left_val = rob(root.left.left);
			int left_right_val = rob(root.left.right);
			rootval += left_left_val+left_right_val;
			leftHand = rob(root.left);			
		}
		if(root.right != null){
			int right_left_val = rob(root.right.left);
			int right_right_val = rob(root.right.right);
			rootval += right_left_val+right_right_val;
			rightHand = rob(root.right);			
		}
		return Math.max(leftHand+rightHand, rootval);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.left.left = null;
		root.right.left = null;
	 
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(1);
		System.out.println(new house_robber_III().rob(root));
	}
}
