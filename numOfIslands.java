package com.leetcode;

public class numOfIslands {

	public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0 ){
        	return 0;
        }
        int res=  0;
        int rows = grid.length;
        int cols = grid[0].length;        
        for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(grid[i][j] == '1'){					
					DFSIslands(grid, i, j, rows, cols);
					res ++;
				}
			}
		}
        return res;
    }
	
	public void DFSIslands(char[][] grid, int i , int j, int rows,  int cols) {
		if(i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != '1'){
			return;
		}
 
		grid[i][j] = '0';
		DFSIslands(grid, i-1, j, rows, cols);
		DFSIslands(grid, i+1, j, rows, cols);
		DFSIslands(grid, i, j-1, rows, cols);
		DFSIslands(grid, i, j+1, rows, cols);
	}
	
	public static void main(String[] args) {
//		 char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		 char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		 System.out.println(new numOfIslands().numIslands(grid));
	}
}
