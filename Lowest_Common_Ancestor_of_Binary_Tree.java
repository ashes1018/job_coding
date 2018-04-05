package com.leetcode;

public class Lowest_Common_Ancestor_of_Binary_Tree {
	static class TreeNode {
		   int val;
		   TreeNode left;
		   TreeNode right;
		   TreeNode(int x) { val = x; }
	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null){
			return null;
		}
		if(root == p){
			return p;
		}
		if(root == q){
			return q;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if(left != null && right != null){
			return root;
		}
		return left != null ? left:right;
    }
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(5);
		node.left.left = new TreeNode(6);
		node.left.right = new TreeNode(2);
		node.right =new TreeNode(1);
		System.out.println(new Lowest_Common_Ancestor_of_Binary_Tree().lowestCommonAncestor(node, node.left, node.left.left).val);
		
	}
}
