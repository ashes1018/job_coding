package com.leetcode;

public class Product_of_Array_Except_Self {
	
//	计算一列数组，除了自身之外其他所有元素的乘积之和。维护两个数组，分别记录一前一后到当前位置的乘积之和，最后结果就是这两个数组对应位置的值相乘。
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		if(nums == null || nums.length == 0){
			return res;
		}
		int[] begin =  new int[nums.length];
		int[] end =  new int[nums.length];
		begin[0] = 1;
		end[nums.length - 1] = 1;
		for(int i = 1 ; i < nums.length ; i++){
			begin[i] = begin[i-1] * nums[i-1];  
		}
		for(int i = nums.length - 2 ; i >= 0  ; i--){
			end[i] = end[i+1] * nums[i+1];  
		}
		for(int i = 0 ; i < nums.length ; i++){
			res[i] = begin[i] * end[i];
		}
		return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] res = new Product_of_Array_Except_Self().productExceptSelf(nums);
		for (int i : res) {
			System.out.println(i);
		}

	}

}
