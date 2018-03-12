package com.leetcode;

public class word_search {
	
	
//	这道题也是DFS的变形。首先写dfs函数。从左上角开始，对每一个位置，分别遍历其上下左右四个位置的值，看是否和word的每个位置的值相等。
	public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0){
        	return true;
        }
        if(board == null || board.length ==0 || board[0].length ==0 ){
        	return false;
        }
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(dfs(board, word, 0, i, j, used)){
					return true;
				}
			}
		}
        return false;
    }
//	注意边界条件的判断。注意在遍历的过程中，一个位置被访问后，当这一轮访问结束后，则置该位置为false，在下一轮还是可以使用的。
	public boolean dfs(char[][]board, String word, int index , int i , int j , boolean[][] used) {
		if(index == word.length()){
			return true;
		}
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || used[i][j] || board[i][j] != word.charAt(index)){
			return false;
		}
		used[i][j] = true;
		boolean res = dfs(board, word, index+1, i-1, j, used) ||
				dfs(board, word, index+1, i+1, j, used) ||
				dfs(board, word, index+1, i, j+1, used) ||
				dfs(board, word, index+1, i, j-1, used);
		used[i][j] = false;
		return res;
	}
	
	public static void main(String[] args) {
		 char[][] board ={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		 String word1 = "ABC";
		 String word2 = "ABCB";
		 System.out.println(new word_search().exist(board, word1));
		 System.out.println(new word_search().exist(board, word2));
	}

}
