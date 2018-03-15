package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class maximal_rectangle {

	
//	这道题的思想很巧妙，借助网上的方法，在遍历每一行的时候，对每一行的数字，计算该数字对应的列直方图高度，若遇到数字为0，则置0；否则就加1；对每一行得到的直方图，
//	使用之前计算最大直方图面积的方法。
	
	public int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length ==0 || matrix[0].length == 0){
			return 0;
		}
		int maxArea = 0;
		int[] nums = new int[matrix[0].length];
		for(int i = 0 ; i < matrix.length ; i++){
			for(int j = 0 ;j < matrix[0].length; j++){
			if(matrix[i][j] == '0'){
				nums[j] = 0;
			}else {
				nums[j] = 1 + nums[j];
			} 			
		}
			maxArea = Math.max(maxArea, largest_rectangle_in_histogram(nums));
    }
		return maxArea;
}

	public int largest_rectangle_in_histogram(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		int []h = new int[nums.length + 1];
		h = Arrays.copyOf(nums, nums.length + 1);
		int maxArea = 0;
		while (i < h.length) {
			if(stack.isEmpty() || h[stack.peek()] <= h[i]){
				stack.push(i++);
			}else{
				int t = stack.pop();
				maxArea = Math.max(maxArea, h[t]*(stack.isEmpty()? i: i-stack.peek()-1));
			}
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
//		 char[][] matrix= {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};		
		 char[][] matrix = {{'0','1'},{'1','0'}};
		 System.out.println(new maximal_rectangle().maximalRectangle(matrix));
		 
	}

}
