package com.leetcode;

import java.security.Principal;

import javax.xml.soap.Node;

public class convert_bst_to_greater_tree {
	
	static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
	int sum = 0;
	public TreeNode convertBST(TreeNode root) {
		
		convert(root );
		return root;
    }
	
	public  void convert(TreeNode root ){
		if(root == null){
			return;
		}
		convert(root.right);
		root.val += sum;
		sum = root.val;
		convert(root.left);
	}
	
	
	public static void main(String[] args) {
		 TreeNode root = new TreeNode(5);
		 root.left = new TreeNode(2);
		 root.right = new TreeNode(13);
		 TreeNode node = new convert_bst_to_greater_tree().convertBST(root);
		 System.out.println(node.val);
		 System.out.println(node.left.val);
		 System.out.println(node.right.val);
	}

}
