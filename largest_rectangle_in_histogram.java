package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class largest_rectangle_in_histogram {
	
//	ֱ�۵ı����ⷨ���������ң�����ָ��һǰһ�������
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
	
	
//	���ֽⷨ��ά����һ��ջ�������洢��Ӧֵ���±ꡣ��������ʱ��������������ʱ���ͽ���������ֶ�Ӧ���±����ջ�У�����ջ��Ԫ�س�ջ�����������
//	Ȼ�������ֽⷨ��ȫ�벻������
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
