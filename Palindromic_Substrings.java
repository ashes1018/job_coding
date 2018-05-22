package com.leetcode;

import java.util.Arrays;

public class Palindromic_Substrings {
	
	
	
//	这种解法，先定义中心，中心可以是每个元素，也可以是两个元素之间的空位，这样中心数就有2*N-1个。从每个中心开始，依次向左向右扩展，判断是否是回文。
	public int countSubstrings(String S) {
		int N = S.length();
		int res = 0;
		for(int center = 0; center <= 2 * N -1; ++center){
			int left = center / 2;
			int right = left + center%2;
			
			while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
				res ++;
				left--;
				right++;
			}
		}
		return res;
	}
	
//	使用DP解决，dp[i][j]表示的是在[i,j]之间的是不是回文。
	public int countSubstrings_2(String S) {
		int count = 0;
		int n = S.length();
		count += n;
		boolean[][] dp = new boolean[n][n];
		for(int i = 0; i < n; i++){
			dp[i][i] = true;
		}
		for(int len =1; len < n; len ++){
			for (int i = 0; i < n - len; i++) {
				int j = i +len;
				if(S.charAt(i) != S.charAt(j)){
					dp[i][j] =false;
				}else {
					dp[i][j] = isPalndromic(dp, i+1, j-1);
					if(dp[i][j] == true){
						count += 1;
					}
				}
				
			}
		}
		return count;
	}
	
	public boolean isPalndromic(boolean[][] dp, int i ,int j){
		if(i >= j){
			return true;
		}
		else {
			return dp[i][j];
		}
	}
	
	public static void main(String[] args) {
		String S = "cabac";
		System.out.println(new Palindromic_Substrings().countSubstrings(S));
		System.out.println(new Palindromic_Substrings().countSubstrings_2(S));
	}

}
