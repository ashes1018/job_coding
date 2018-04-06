package com.leetcode;

import java.util.Arrays;

public class perfect_squares {

	public int numSquares(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
//		for (int i = 0; i * i <= n; i++) {
//			dp[i * i] = 1;
//		}
		
		for(int i = 1 ; i <= n; i++){
			for(int j = 1; i + j * j <= n; j++){
				dp[i+j*j] =   Math.min(dp[i] + 1,dp[i+j*j]);
			}
		}
		return dp[n];
	}
	
	
	public int numSquares2(int n) {
		int i = 1;
		int res = n;
		while (i * i <= n) {
			int a = n /(i * i);
			int b = n %(i * i);
			res = Math.min(res, numSquares2(b)+a);
			++i;
		}
		return res;
	}
		
	public static void main(String[] args) {
		System.out.println(new perfect_squares().numSquares(13));
		System.out.println(new perfect_squares().numSquares2(13));
	}
}
