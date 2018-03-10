package com.leetcode;

public class sort_colors {
	
//	�����Ľⷨ���ǣ���������ָ�룬һǰһ������notred��notblue���ֱ��¼�����ĵ�һ��notred�͵�һ��notblue��indexֵ�����õ�����ָ��i����notred��ʼ�������0�Ļ���
//	���notred���н����������2�Ļ������notblue���������򣬲�������,i++;
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
