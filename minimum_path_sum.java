package com.leetcode;

public class minimum_path_sum {
	
	
//	DP。首先设置cost[0][0]= grid[0][0]，确定边界条件；其次对cost[0][i]和cost[i][0]这样的边界条件计算；最后使用dp思想。
	public int minPathSum(int[][] grid) {
		int[][] cost = new int[grid.length][grid[0].length];
		cost[0][0]= grid[0][0];
		if(grid.length ==0 || grid[0].length == 0 ){
			return 0;
		}
		for(int i = 1 ; i< grid.length ; i++){
			cost[i][0] = grid[i][0]+cost[i-1][0];
		}
		for(int i = 1 ; i< grid[0].length ; i++){
			cost[0][i] = grid[0][i] + cost[0][i-1];
		}
		for(int i = 1; i< grid.length; i++){
			for(int j =1 ; j< grid[0].length; j++){
				cost[i][j] = Math.min(cost[i-1][j], cost[i][j-1]) + grid[i][j];
			}
		}
		return cost[grid.length-1][grid[0].length-1];
    }

	public static void main(String[] args) {
		int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(new minimum_path_sum().minPathSum(grid));
	}
}
