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
	
	
//	�����ʹ��BFS��˼�롣ά��2��queue����һ��queue��Ϊһ����ʱ�Ĵ洢���ߣ����Դ洢��һ�������Ԫ�أ�queue2����������ǰqueue�е�����Ԫ�ء�ͬʱά������list��
//	��һ���洢����ÿһ���Ԫ��ֵ���ڶ����洢��������Ԫ��ֵ��
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
