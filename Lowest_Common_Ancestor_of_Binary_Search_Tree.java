package com.leetcode;

import com.leetcode.Lowest_Common_Ancestor_of_Binary_Tree.TreeNode;


//Ѱ��һ�ö��������������������ڵ�Ĺ�ͬ���ȡ�
public class Lowest_Common_Ancestor_of_Binary_Search_Tree {
	static class TreeNode {
		   int val;
		   TreeNode left;
		   TreeNode right;
		   TreeNode(int x) { val = x; }
	}
//	�ݹ鷽��
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null){
			return null;			
		}
		if(root.val > p.val && root.val > q.val){
			return lowestCommonAncestor(root.left, p, q);
		}
		if(root.val < p.val && root.val < q.val){
			return lowestCommonAncestor(root.right, p, q);
		}
		return root;
	}
//	�ǵݹ鷽��
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null){
			return null;
		}
		while (true) {
			if(root.val > p.val && root.val > q.val){
				root = root.left;
			}else if (root.val < p.val && root.val < q.val) {
				root = root.right;
			}else {
				break;
			}
		}
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(4);
		node.left.left = new TreeNode(2);
		node.left.right = new TreeNode(3);
		node.right =new TreeNode(6);
		System.out.println(new Lowest_Common_Ancestor_of_Binary_Search_Tree().lowestCommonAncestor(node, node.left, node.left.left).val);		
		System.out.println(new Lowest_Common_Ancestor_of_Binary_Search_Tree().lowestCommonAncestor2(node, node.left, node.left.left).val);
	}
}