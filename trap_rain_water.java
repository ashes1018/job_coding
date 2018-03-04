package com.leetcode;

public class trap_rain_water {

//	暴力解法，从左往右遍历，在每一个index处，分别找出在这个index左边和右边最大值，然后计算min(left_max[index],right_max[index])-nums[index]
	public int brute_way(int[] nums) {
		int res = 0;		
		for (int i = 1; i < nums.length; i++) {
			int right_max = 0,left_max = 0;
			for(int j = i ; j >=0; j -- ){
				left_max = Math.max(left_max, nums[j]);
			}
			for(int j = i; j< nums.length; j++){
				right_max = Math.max(right_max, nums[j]);
			}
			res += Math.min(left_max, right_max) - nums[i];
		}
		return res;
	}

//	动规。首先维护两个数组，分别记录每个位置左右的最大值；再遍历一次，取较小值进行运算。
	public int dp_way(int[] nums) {
		int[] left_max  = new int[nums.length];
		int[] right_max  = new int[nums.length];
		int res = 0;
		left_max[0] = nums[0];
		for(int i = 1; i < nums.length; i++) {
			left_max[i] = Math.max(left_max[i-1], nums[i]);
		}
		right_max[nums.length-1] = nums[nums.length - 1];
		for(int j = nums.length - 2; j >=0 ; j--){
			right_max[j] = Math.max(right_max[j+1], nums[j]);
		}
		for(int i = 1 ; i < nums.length-1 ; i++){
			res += Math.min(left_max[i], right_max[i]) - nums[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
//		int[] nums= {0,1,0,2,1,0,1,3,2,1,2,1};
		int[] nums = {2,0,2};
		System.out.println(new trap_rain_water().brute_way(nums));
		System.out.println(new trap_rain_water().dp_way(nums));
	}
}
