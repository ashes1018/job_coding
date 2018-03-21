package com.leetcode;

public class unique_binary_search_tree {

//	��֪�����������ô�Ϳ���������ϵ�ϵģ�����������ϵ���ϡ����⣬��ϰһ�¶����������ĸ��һ���ڵ���������ϵĽڵ�ض�����С�ڸýڵ��ֵ�ģ����ҽڵ��ϵ�ֵ�ض�����
//	���ڸýڵ��ֵ�ġ�
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