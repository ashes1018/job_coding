package com.leetcode;

public class unique_paths {
	
//	��̬�滮��ÿ���㴦���߷����������º�����������ɵģ�������Ҫע��һ����ǣ� �ڸ����ٽ�㣬Ҳ����dp[0][1]��dp[0][2]��dp[0][3]��λ����Ϊ�ٽ�㣬����Ҫ�ȶ��丳ֵ�ġ�
	public int uniquePaths(int m, int n) {
		if(m == 0 || n ==0){
			return 0;
		}
		if (m == 1|| n == 1) {
			return 1;
		}
		int[][] dp = new int[m][n];
		for(int i = 0 ;i < n ;i++){
			dp[0][i] = 1;
		}
		for(int i = 0 ;i < m ;i++){
			dp[i][0] = 1;
		}
		for(int i = 1; i< m; i++){
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
			}
		}
		return dp[m-1][n-1];
	}
	
	public static void main(String[] args) {
		 System.out.println(new unique_paths().uniquePaths(4, 3));
	}

}
