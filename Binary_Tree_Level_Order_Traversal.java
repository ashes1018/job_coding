package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal {
	
	static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	
	
//	这道题使用BFS的思想。维护2个queue，第一个queue作为一个临时的存储工具，用以存储下一层的所有元素；queue2用作遍历当前queue中的所有元素。同时维护两个list，
//	第一个存储的是每一层的元素值，第二个存储的是所有元素值。
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null){
            return res;    
        }
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();			
			for (TreeNode node : queue) {
				list.add(node.val);				
			}
			res.add(list);			
			Queue<TreeNode> queue2 = queue;			
			queue = new LinkedList<>();
			for (TreeNode Node : queue2) {
				if(Node.left != null){
					queue.add(Node.left);				
				}
				if(Node.right != null){
					queue.add(Node.right);				
				}
			}					
		}
		return res;
    }
	
	public static void main(String[] args) {	
		 TreeNode root = new TreeNode(3);
		 root.left = new TreeNode(9);
		 root.left.left = null;
		 root.left.right = null;
		 root.right = new TreeNode(20);
		 root.right.left = new TreeNode(15);
		 root.right.right = new TreeNode(7);
		 System.out.println(new Binary_Tree_Level_Order_Traversal().levelOrder(root));
	}

}
