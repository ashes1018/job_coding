package com.leetcode;

public class jianzhi_isBinaryBalanceTree {
	static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
	
	public boolean isBinaryBT(TreeNode root) {
		if(root == null){
			return true;
		}
		int left = height(root.left);
		int right = height(root.right);
		if(Math.abs(left - right) > 1){
			return false;
		}
		return isBinaryBT(root.left) && isBinaryBT(root.right);
	}
	
	public int height(TreeNode node) {
		if(node == null){
			return 0;
		}
		int left = height(node.left);
		int right = height(node.right);
		return left > right?left + 1:right + 1;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.left.right.left = new TreeNode(7);
		System.out.println(new jianzhi_isBinaryBalanceTree().isBinaryBT(root));
		
		
	}

}
