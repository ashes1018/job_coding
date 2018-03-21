package com.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.leetcode.Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal.TreeNode;

public class Flatten_Binary_Tree_to_Linked_List {
	
	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	
	public TreeNode flatten(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();		
		TreeNode p = root;
		Queue<TreeNode> queue = new LinkedList<>();
		while (!stack.isEmpty() || p != null) {
			while (p != null) {
				queue.add(p);
				stack.push(p);
				p = p.left;
			}
			if(!stack.isEmpty()){
				p = stack.pop();
				p = p.right;
			}
		}
 
//		for (TreeNode treeNode : queue) {
//			System.out.println(treeNode.val);
//		}
		TreeNode pp = null;
		TreeNode ppp = queue.poll();
		while (!queue.isEmpty()) {
			pp = queue.poll();
			ppp.right = pp;
			
			ppp = ppp.right;
		}
		return ppp;
    }
	
	public static void main(String[] args) {
		 TreeNode root = new TreeNode(1);
		 root.left = new TreeNode(2);
		 root.left.left = new TreeNode(3);
		 root.left.right = new TreeNode(4);
		 root.right = new TreeNode(5);
		 root.right.left = null;
		 root.right.right = new TreeNode(6);
		 System.out.println(new Flatten_Binary_Tree_to_Linked_List().flatten(root).right);
	}

}
