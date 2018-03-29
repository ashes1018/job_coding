package com.leetcode;

import com.leetcode.Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal.TreeNode;

public class jianzhi_next_node_of_binaryTree {

	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode parent;
	      TreeNode(int x) { val = x; }
	}
	
	public TreeNode getNext(TreeNode node) {
		if(node == null){
			return node;
		}
		TreeNode pNext = null;
		if(node.right != null){
			TreeNode pRight = node.right;
			while (pRight.left != null) {
				pRight = pRight.left;
			}
			pNext = pRight;
		}else if(node.parent != null){
			TreeNode curr = node;
			TreeNode parent = node.parent;
			TreeNode pRight = parent.right;
			while (parent != null && pRight != null) {
				pRight = parent;
				parent = parent.parent;
			}
			pNext = parent;
		}
		return pNext;
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.left.right.left = new TreeNode(8);
		node.left.right.right = new TreeNode(9);
		node.left.right.left.left = null;
		node.left.right.left.right = null;
		node.left.right.right.left = null;
		node.left.right.right.right = null;
		node.right = new TreeNode(3);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		
		jianzhi_next_node_of_binaryTree demo = new jianzhi_next_node_of_binaryTree();
		System.out.println(demo.getNext(node.left.right.right).val);
		
	}

}
