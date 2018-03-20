package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Validate_Binary_Search_Tree {

	static class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
	}
	
	
	public boolean isValidBST(TreeNode root) {
		List<Integer> list = new ArrayList<>();
        if(root.left == null && root.right == null) return true;
        
        helper(root ,list);
 
        for (int i = 1; i < list.size(); i++) {
			if(list.get(i) <= list.get(i-1)){
				return false;
			}
        }
        return true;
    }
	
	public void helper(TreeNode root, List<Integer> list) {
		if(root == null){
			return;
		}
		helper(root.left, list);
		list.add(root.val);
		helper(root.right, list );
	}
	public static void main(String[] args) {
		TreeNode root=  new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.left.right = null;
		root.right.left = null;
		root.right.right = new TreeNode(3);
		System.out.println(new Validate_Binary_Search_Tree().isValidBST(root));
	}
}
