package com.leetcode;

import java.util.Arrays;

public class coin_change {
	
//	��������ⷨ��dp[i]��ʾ����Ǯ��Ϊiʱ������Ҫ����С��Ǯ������
	public int coinChange(int[] coins, int amount) {
		if(coins == null || coins.length == 0 || amount < 0 ){
			return 0;
		}
		int[] dp = new int[amount+1];
//		��dp�����ÿ��λ�ã���ʼ������ҪӲ���������ֵ��
		Arrays.fill(dp, amount +1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if(coins[j] <= i){
					dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
				}				
			}
		}
		return dp[amount]> amount ? -1:dp[amount];
    }
	
	public static void main(String[] args) {
		int[] coins = {1,2,5};
		System.out.println(new coin_change().coinChange(coins, 11));
	}
}
