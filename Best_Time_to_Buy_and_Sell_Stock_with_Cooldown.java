package com.leetcode;

public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

	public int maxProfit(int[] prices) {
		int n = prices.length;
		if(prices == null || prices.length ==0 || prices.length == 1){
			return 0;
		}
		
		
		
		int[] buy = new int[n+1];
		int[] sell = new int[n+1];
		
		sell[0] = 0;
		sell[1] = Math.max(0, prices[1]-prices[0]);		
		buy[0] = -prices[0];
		buy[1] = Math.max(buy[0], -prices[1]);			
		for (int i = 2; i < prices.length; i++) {
			buy[i] = Math.max(buy[i-1], sell[i-2]-prices[i]);
			sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
		} 
		return sell[n-1];
		
			
    }
	
	public static void main(String[] args) {
		 int[] prices = {1,2,4};
		 System.out.println(new Best_Time_to_Buy_and_Sell_Stock_with_Cooldown().maxProfit(prices));

	}

}
