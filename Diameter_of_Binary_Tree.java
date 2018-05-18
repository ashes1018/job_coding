package com.leetcode;

public class Diameter_of_Binary_Tree {

	static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
//	全局变量，记录路径最长是多少
	int d = 0;
	
//	最长长度等价于 max(左子树最长长度，右子树最长长度，左子树最长长度+右子树最长长度)	
	public int diameterOfBinaryTree(TreeNode root) {
		getDepth(root);
		return d;
    }
	
	public int getDepth(TreeNode root) {
		if(root == null) return 0;
		int l = getDepth(root.left);
		int r = getDepth(root.right);
		d = Math.max(l+r, d);
		return Math.max(l, r) + 1;
	}
	
	public static void main(String[] args) {
		 TreeNode root = new TreeNode(1);
		 root.left = new TreeNode(2);
		 root.right = new TreeNode(3);
		 root.left.left = new TreeNode(4);
		 root.left.right = new TreeNode(5);
		 System.out.println(new Diameter_of_Binary_Tree().diameterOfBinaryTree(root));

	}

}
