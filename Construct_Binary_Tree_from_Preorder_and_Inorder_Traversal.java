package com.leetcode;

import com.leetcode.Binary_Tree_Level_Order_Traversal.TreeNode;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length-1);
    }
	
	public TreeNode helper(int[] pre , int preStart,int preEnd,  int[] in, int inStart, int inEnd) {
		if(preStart > preEnd || inStart > inEnd){
			return null;
		}
		int rootVal = pre[preStart];
		int index  = 0;
		for(int i = 0 ; i <= in.length ; i++){
			if(rootVal == in[i]){
				index = i;
				break;
			}
		}
		int len = index - preStart;
		TreeNode root = new TreeNode(rootVal);
		root.left = helper(pre, preStart + 1,preStart + len, in, inStart, index - 1);
		root.right = helper(pre, preStart + len + 1, preEnd, in, index + 1, inEnd);
		return root;
	}
	public static void main(String[] args) {
		 int[] preorder = {3,9,20,15,7};
		 int[] inorder = {9,3,15,20,7};
		 TreeNode root = new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal().buildTree(preorder, inorder);
		 System.out.println(root.val);
		 System.out.println(root.left.val);
		 System.out.println(root.right.val);

	}

}
