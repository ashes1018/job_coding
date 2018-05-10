package com.leetcode;

import javax.swing.text.rtf.RTFEditorKit;

public class path_sum_III {

	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		   }
	
//	思路就是从根节点开始，递归计算除去当前节点，剩下节点加起来等于sum的个数。
	public int pathSum(TreeNode root, int sum) {
		if(root == null){
			return 0;
		}
		return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}
	
	public int findPath(TreeNode root, int sum) {
		if(root == null){
			return 0;
		}
		int res = 0;
		if(root.val == sum){
			res += 1;
		}
		res += findPath(root.left, sum-root.val);
		res += findPath(root.right, sum-root.val);
		return res;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		root.left.right.left = null;
		root.left.right.right = new TreeNode(1);
		root.right = new TreeNode(-3);
		root.right.right = new TreeNode(11);
		root.right.left = null;
		System.out.println(new path_sum_III().pathSum(root, 8));
	}
}
