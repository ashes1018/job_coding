package com.leetcode;

public class maximum_subarray {
	
//	使用动态规划。
	  public int maxSubArray(int[] nums) {
	        int[] dp = new int[nums.length];
	        int max = nums[0];
	        dp[0] = nums[0];
	        int []max_array = new int[nums.length];
	        for(int i = 1 ;i< nums.length; i++){
	            dp[i] = Math.max(nums[i] + dp[i-1],nums[i]);
	            int index1 = 0,index2 = 0;
	            if(dp[i] > max){
	                max = dp[i];
	            }
	        }
	        return max;
	    }
	  
//	 分治解法，以mid为分界点，
	  	public int helper(int[] nums, int left, int right){
	  		if(nums == null || nums.length == 0){
	  			return 0;
	  		}
	  		if(left == right){
	  			return nums[left];
	  		}
	  		if(left == right - 1){
	  			return Math.max(Math.max(nums[left], nums[right]), nums[left]+nums[right]);
	  		}
	  		int mid = (left + right)/2;
	  		int lmax = helper(nums, left, mid-1);
	  		int rmax = helper(nums, mid+1, right);
	  		
	  		int mmax= nums[mid];	  		
	  		int tmp = mmax;
	  		for(int i = mid - 1 ; i>=left; i--){
	  			mmax = Math.max(nums[i]+tmp, mmax);
	  		}
	  		tmp = mmax;
	  		for(int i = mid+1; i <= right ; i++ ){
	  			mmax = Math.max(nums[i]+tmp, mmax);
	  		}
	  		return Math.max(mmax, Math.max(lmax, rmax));	  		
	  	}
	  	
	  	public int max_subArray_2(int[] nums) {	
			return helper(nums, 0, nums.length - 1);
		}
	  	
	public static void main(String[] args) {
		 int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		 System.out.println(new maximum_subarray().maxSubArray(nums));
		 System.out.println(new maximum_subarray().max_subArray_2(nums));
	}

}
