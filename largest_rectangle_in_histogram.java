package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class largest_rectangle_in_histogram {
	
//	直观的暴力解法。从左往右，两个指针一前一后遍历。
	public int largestRectangleArea(int[] heights) {
		int maxArea = 0;		
		for (int i = 0; i < heights.length - 1; i++) {
			int min = heights[i];
			for(int j = i+1; j< heights.length ; j++ ){
				min = Math.min(min, heights[j]);
				maxArea = Math.max(maxArea, min * (j - i + 1 ));
			}
		}
		return maxArea;
	}
	
	
//	这种解法，维护了一个栈，用来存储对应值的下标。遍历序列时，当序列是升序时，就将升序的数字对应的下标加入栈中；否则，栈顶元素出栈，计算面积。
//	然而，这种解法完全想不到啊。
	public int largestRectangleArea2(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int i =0;
		int maxarea = 0;
		int[] h = new int[heights.length + 1];
		h = Arrays.copyOf(heights, heights.length + 1);		
		while (i < h.length) {
			if(stack.isEmpty() || h[stack.peek()] <= h[i]){
				stack.push(i++);				
			}else{
				int t = stack.pop();
				maxarea = Math.max(maxarea, h[t] * (stack.isEmpty()? i: i - stack.peek() - 1));
			}
		}
		return maxarea;
	}
	
	public static void main(String[] args) {
		 int[] nums = {2,6,2,3};
		 System.out.println(new largest_rectangle_in_histogram().largestRectangleArea(nums));
		 System.out.println(new largest_rectangle_in_histogram().largestRectangleArea2(nums));
	}

}
