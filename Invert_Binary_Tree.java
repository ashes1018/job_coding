package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Invert_Binary_Tree {
	
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
//	使用一个队列，存储还没有被交换的节点，初始时只有root在。
	public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			TreeNode temp = curr.left;
			curr.left = curr.right;
			curr.right = temp;
			if(curr.left != null) queue.add(curr.left);
			if(curr.right != null) queue.add(curr.right);
		}
        return root;
    }
	
//	使用递归的方法。
	public TreeNode invertTree_2(TreeNode root) {
		if(root == null){
			return null;
		}		
		TreeNode right = invertTree(root.right);
		TreeNode left = invertTree(root.left);
		root.left = right;
		root.right = left;
		return root;
	}
	
	public static void main(String[] args) {
		 TreeNode node = new TreeNode(4);
		 node.left = new TreeNode(2);
		 node.right = new TreeNode(7);
		 node.left.left = new TreeNode(1);
		 node.left.right = new TreeNode(3);
		 
		 node.right.left = new TreeNode(6);
		 node.right.right = new TreeNode(9);
		 
//		 System.out.println(new Invert_Binary_Tree().invertTree(node).left.val);
		 System.out.println(new Invert_Binary_Tree().invertTree_2(node).left.val);
	}
}
