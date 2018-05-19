package com.leetcode;

import java.awt.event.MouseWheelEvent;

import com.leetcode.binary_tree_inorder_traversal.TreeNode;

public class Subtree_of_Another_Tree {

	static public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
	
	
//	���ֽⷨ��˼·�����ö�������ǰ�������������ʾΪ�ַ�������ʽ������ת�����ַ����Ӵ����⡣��������ĿҪ����ÿ���ڵ�ǰ����һ����־λ��#�����Ը��ý�����⡣
	public boolean isSubtree(TreeNode s, TreeNode t) {
		String tree1 = preorder(s, true);
		String tree2 = preorder(t, true);
		return tree1.indexOf(tree2) >= 0;
		
	}
	
	public String preorder(TreeNode t, boolean left) {
		if(t == null){
			if(left){
				return "lnull";
			}else {
				return "rnull";
			}
		}
		return "#"+ t.val + " "+preorder(t.left, true) + " " + preorder(t.right, false);
	}
	
//	����s����ÿһ���ڵ㣬�ж��Ըýڵ��ʸ��ڵ�������Ƿ��tһ����
	public boolean isSubtree_2(TreeNode s, TreeNode t) {
		if(s == null){
			return false;
		}
		if(isSame(s, t)){
			return true;
		}
		return isSame(s.left, t) || isSame(s.right, t);
	}
	
	public boolean isSame(TreeNode s, TreeNode t) {
		if(s == null && t==null){
			return true;			
		}
		if(s == null || t == null){
			return false;
		}
		if(s.val != t.val){
			return false;
		}
		return isSame(s.left, t.left) && isSame(s.right, t.right);
	}
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(4);
		root1.right = new TreeNode(5);
		root1.left.left = new TreeNode(1);
		root1.left.right = new TreeNode(2);
		root1.right = new TreeNode(5);
		
		TreeNode root2 = new TreeNode(4);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(2);
		
		System.out.println(new Subtree_of_Another_Tree().isSubtree(root1, root2));
		System.out.println(new Subtree_of_Another_Tree().isSubtree_2(root1, root2));
	}

}
