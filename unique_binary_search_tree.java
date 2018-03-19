package com.leetcode;

public class unique_binary_search_tree {

//	不知道这道题是怎么和卡特兰数联系上的，反正我是联系不上。另外，复习一下二分搜索树的概念，一个节点的左子树上的节点必定都是小于该节点的值的；而右节点上的值必定都是
//	大于该节点的值的。
	public int numTrees(int n) {
		int[] res = new int[n+1];
		res[0] = 1;						
		int temp = 0 ;
		for(int i = 1; i <= n; i++){
			for(int j = 0; j < i; j++){
				res[i] += res[j] * res[i- j-1];
			}
		}				
		return res[n];
    }
	
	public static void main(String[] args) {
		System.out.println(new unique_binary_search_tree().numTrees(3));

	}

}
