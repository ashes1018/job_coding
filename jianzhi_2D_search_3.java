package com.leetcode;

public class jianzhi_2D_search_3 {
	
//	��ָoffer�����⡣��������ҵ������Ͻǵ�Ԫ�أ�������ֵ��target��Ļ�����ô�Ϳ��Ժ��Ը�ֵ�����е�ֵ����֮�����Ժ��������е�����ֵ������һ������С��Χ��
	public boolean search(int[][] nums, int target) {
		if(nums == null){
			return false;
		}		
		int rows = nums.length;
		int cols = nums[0].length;
		int row = 0;
		int col = cols - 1;
		boolean found = false;
		while (row < rows && col >= 0) {
			if(nums[row][col] == target){
				found = true;
				break;
			}
			else if(nums[row][col] > target ){
				col = col -1;
			}else {
				row = row + 1;
			}
		}
		return found;		
	}
	
	public static void main(String[] args) {
		 int[][] nums = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		 System.out.println(new jianzhi_2D_search_3().search(nums, 15));
	}
}
