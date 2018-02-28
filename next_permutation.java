package com.leetcode;

public class next_permutation {
	
	public void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums == null){
            return;
        }        
        int index = nums.length - 2;
        while(nums[index] >= nums[index+1] && index >= 0){
            index--;
        }
        if(index >= 0){
            int j = nums.length-1;
            while(nums[j] <= nums[index]){
                --j;
            }
            swap(nums, j,index);
        }
        
        int n = nums.length - 1;
        index++;
        while(index < n){
        	swap(nums, index, n);
        	index ++;
        	n--;
        }
//        for(; index < n;index++,n--){
//        	swap(nums, index, n);
//        }        
    }
    
    public void swap(int[]arr, int i ,int j){
        int temp = 0;
        temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }
	
	public static void main(String[] args) {
		int[] nums= {6,1,8,7,4};
		new next_permutation().nextPermutation(nums);
		for (int i : nums) {
			System.out.println(i);
		}
	}

}
