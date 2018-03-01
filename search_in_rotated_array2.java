package com.leetcode;


//数组出现重复的值，和第一版本的相似，但是在判断的时候，注意边界，这里是将边界往另一个方向加一
public class search_in_rotated_array2 {
	public int findIndex(int[]nums, int target){
		int n = nums.length;
		int left = 0;
		int right = n-1;
		
		while (left <= right) {
			int mid = (left + right)/2;
			if(nums[mid] == target){
				return mid;
			}
			if(nums[mid] < nums[left]){
				if(nums[right] >= target && nums[mid] < target){
					left = mid + 1;
				}else{
					right = mid - 1;
				}
			}else if(nums[mid] > nums[left]){
				if(nums[left] <= target && nums[mid] > target){
					right = mid - 1;
				}else {
					left = mid + 1;
				}
			}else {
				left++;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] A = {4,4,4,4,7,0,1};
		System.out.println(new search_in_rotated_array2().findIndex(A, 1));
	}
}
