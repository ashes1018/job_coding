package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class binary_tree_inorder_traversal {

	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			 val = x;
		}
	}
	
//	这个题还是典型的递归题，递归题记住要另外借助一个函数。
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
	
	public void helper(TreeNode root, List<Integer> res) {
		if(root != null){
			if(root.left != null){
				helper(root.left, res);
			}
			res.add(root.val);
			if(root.right != null){
				helper(root.right, res);
			}			
		}		
	}
	
	
	public List<Integer> stack_traverse(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		while(curr != null || !stack.isEmpty()){
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			res.add(curr.val);
			curr = curr.right;
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		 
		 TreeNode node = new TreeNode(1);
		 node.left = null;
		 node.right = new TreeNode(2);
		 node.right.left = new TreeNode(3);
		 node.right.right = null;
		 System.out.println(new binary_tree_inorder_traversal().inorderTraversal(node));
		 System.out.println(new binary_tree_inorder_traversal().stack_traverse(node));
	}

}
