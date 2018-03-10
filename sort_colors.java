package com.leetcode;

public class sort_colors {
	
//	这道题的解法就是，设置三个指针，一前一后两个notred和notblue，分别记录遇见的第一个notred和第一个notblue的index值。设置第三个指针i，从notred开始，如果是0的话，
//	则和notred进行交换，如果是2的话，则和notblue交换；否则，不作操作,i++;
	public void sortColors(int[] nums) {
        if(nums.length ==0 || nums ==null){
        	return;
        }
        int notred = 0;
        int notblue = nums.length - 1;
        while (notred < nums.length && nums[notred] == 0) {
			notred ++;
		}
        while (notblue >=0 && nums[notblue] == 2) {
			notblue--;
		}
        int i = notred;
        while (i <= notblue) {
			if(nums[i] == 0){
				swap(nums, i, notred);
				notred++;
				i++;
			}else if(nums[i] == 2){
				swap(nums, i , notblue);
				notblue--;				
			}else{
				i++;
			}
		}                      
    }
	
	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;		
	}
	public static void main(String[] args) {
		 int nums[] = {0,1,2,0,0,2,2,1,1,1};
		 new sort_colors().sortColors(nums);
		 for (int i : nums) {
			System.out.println(i);
		}

	}

}
