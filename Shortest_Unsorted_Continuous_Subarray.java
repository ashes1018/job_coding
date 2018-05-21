package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Shortest_Unsorted_Continuous_Subarray {
	
//	�������Ҫ�ҳ�һ�������е�һ�������飬�������������������ľ�����������ġ�˼·�����⿪��һ�����飬����ԭ��������֣�����������������󣬽������������ǰ��
//	�ȶԣ�ǰ��ֱ������ֱ���ҵ���һ����Ԫ��,end - start + 1��������Ҫ��ġ�
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
	
//	ʹ��ջ���ֱ��ǰ����ʹӺ���ǰ��������ǰ����������ҵ����������е�Ԫ�أ��ҳ���С��index���Ӻ���ǰ�������ҵ��ǽ����Ԫ�أ��ҳ�����index�����߼�ǰ�ߣ����ɵá�
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
	