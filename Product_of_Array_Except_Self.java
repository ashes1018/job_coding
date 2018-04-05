package com.leetcode;

public class Product_of_Array_Except_Self {
	
//	����һ�����飬��������֮����������Ԫ�صĳ˻�֮�͡�ά���������飬�ֱ��¼һǰһ�󵽵�ǰλ�õĳ˻�֮�ͣ���������������������Ӧλ�õ�ֵ��ˡ�
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
