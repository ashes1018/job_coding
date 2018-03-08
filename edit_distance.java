package com.leetcode;

public class edit_distance {
	
//	DP¡£
	public int minDistance(String word1, String word2) {
		int[][] dp = new int[word1.length()+1][word2.length()+1];
		
		for(int i = 0 ;i <= word1.length() ; i++){
			dp[i][0] = i;
		}
		for(int j = 0 ; j <= word2.length(); j++){
			dp[0][j] = j;
		}
		
		for (int i = 1; i <= word1.length(); i++) {
			char x = word1.charAt(i-1);
			for (int j = 1; j <= word2.length(); j++) {
				char y = word2.charAt(j-1);
				if(x == y){
					dp[i][j] = dp[i-1][j-1];
				}else{
					int delete = dp[i-1][j] + 1;
					int replace = dp[i-1][j-1] +1;
					int insert = dp[i][j-1]+1;
					dp[i][j] = Math.min(Math.min(delete, replace), insert);					
				}				
			}
		}
		return dp[word1.length()][word2.length()];
    }
	public static void main(String[] args) {
		 String word1 = "abcggnf";
		 String word2 = "def";
		 System.out.println(new edit_distance().minDistance(word1, word2));
	}
}
