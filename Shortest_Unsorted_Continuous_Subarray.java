package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Shortest_Unsorted_Continuous_Subarray {
	
//	这道题是要找出一个数组中的一个子数组，子数组有序后，整个数组的就是升序排序的。思路是另外开辟一个数组，复制原数组的数字，进行升序排序，排序后，将两个数组进行前后
//	比对，前后分别遍历，直到找到不一样的元素,end - start + 1就是我们要求的。
	public int findUnsortedSubarray(int[] nums) {
		int[] temp =  new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			temp[i] = nums[i];
		}
		Arrays.sort(temp);
		int n = nums.length;
		int start = 0;
		int end = nums.length - 1;
		while (start < n && nums[start] == temp[start]) {
			start++;
		}
		while (end > start && nums[end] == temp[end]) {
			end--;
		}
		return end - start + 1;
    }
	
//	使用栈。分别从前往后和从后往前遍历，从前往后遍历，找到非升序排列的元素，找出最小的index；从后往前遍历，找到非降序的元素，找出最大的index，后者减前者，即可得。
	public int findUnsortedSubarray_2(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int l  = nums.length;
		int r = 0;
		
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[stack.peek()]  > nums[i]) {
				l = Math.min(l, stack.pop());
			}
			stack.push(i);
		}
		stack.clear();
		for(int j = nums.length - 1; j >= 0; j--){
			while(!stack.isEmpty() && nums[stack.peek()] < nums[j]){
				r = Math.max(r, stack.pop());
			}
			stack.push(j);
		}
		return r- l + 1;		
	}
	
	
	public static void main(String[] args) {
		 int[] nums = {2, 6, 4, 8, 10, 9, 15};
		 System.out.println(new Shortest_Unsorted_Continuous_Subarray().findUnsortedSubarray(nums));
		 System.out.println(new Shortest_Unsorted_Continuous_Subarray().findUnsortedSubarray_2(nums));
	}
}
	