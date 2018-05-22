package com.leetcode;

import java.util.Arrays;

public class Palindromic_Substrings {
	
	
	
//	���ֽⷨ���ȶ������ģ����Ŀ�����ÿ��Ԫ�أ�Ҳ����������Ԫ��֮��Ŀ�λ����������������2*N-1������ÿ�����Ŀ�ʼ����������������չ���ж��Ƿ��ǻ��ġ�
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
	
//	ʹ��DP�����dp[i][j]��ʾ������[i,j]֮����ǲ��ǻ��ġ�
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
