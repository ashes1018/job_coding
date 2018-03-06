package com.leetcode;

public class jump_game {
	
//	从后往前遍历
	public boolean greedy_way(int[] nums) {
		int lastPos = nums.length -1;
		for(int i = nums.length - 1; i >=0 ; i--){
			if(i + nums[i] >= lastPos){
				lastPos = i;
			}			
		}
		return lastPos == 0;
	}
	
enum Index{
	good,bad,unknown;
}	
	Index[] memo;
//	带备忘录的动态规划方法
	public boolean can_jump_dp(int position,int[] nums) {
		if(memo[position] != Index.unknown){
			return memo[position] == Index.good ? true:false;
		}
		int furtherest = Math.min(nums.length - 1, position+nums[position]);
		for(int nextPosition = position+1; nextPosition <= furtherest; nextPosition ++){
			if(can_jump_dp(nextPosition, nums)){
				memo[nextPosition] = Index.good;
				return true;
			}
		}
		memo[position] = Index.bad;
		return false;
	}
	
	
	public boolean canJump(int[] nums){
		memo = new Index[nums.length];
		for (int i = 0; i < memo.length; i++) {
			memo[i] = Index.unknown;
		}
		memo[memo.length - 1] = Index.good;
		return can_jump_dp(0, nums);
	}
	
	public static void main(String[] args) {
		int [] nums = {2,3,1,0,4};
		System.out.println(new jump_game().greedy_way(nums));
		System.out.println(new jump_game().canJump(nums));

	}

}
