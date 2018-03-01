package com.leetcode;

public class search_for_a_range {
	public int[] search_range(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int pos = 0;
		int[] res = {-1,-1};
		if(nums == null || nums.length == 0){
			return res;
		}
 
		while (low <= high) {
			int mid = (low + high)/2;
			pos = mid;
			if(nums[mid] > target){
				high = mid - 1;
			}else if(nums[mid] < target){
				low = mid + 1;
			}else{
				res[0] = pos;
				res[1] = pos;
				break;
			}
		}
		if(nums[pos] != target){
			return res;
		}
		
		
		int newlow = pos;
		int newhigh = nums.length - 1;
		while (newlow <= newhigh) {
			int newmid = (newlow + newhigh)/2;
			if(nums[newmid] == target){
				newlow = newmid + 1;
			}else{
				newhigh = newmid - 1;
				}
			}
		res[1] = newhigh;
		
		newlow = 0;
		newhigh = pos;
		while (newlow <= newhigh) {
			int newmid = (newlow + newhigh)/2;
			if(nums[newmid] == target ){
				newhigh = newmid - 1;
			}else {
				newlow = newmid + 1;
			}
		}
		res[0] = newlow;
		return res;
	}
	
	public static void main(String[] args) {
		 int nums[] = {};
		 int[] res = new search_for_a_range().search_range(nums, 8);
		 for (int i : res) {
			System.out.println(i);
		}

	}

}
