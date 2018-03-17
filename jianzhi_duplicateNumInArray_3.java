package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class jianzhi_duplicateNumInArray_3 {
	
//	�ȶ����������ٽ���һ��set���ϱ������ظ���ֵ����󷵻����set���ϡ�
	public Set<Integer>  find_duplicate1(int[] nums) {
		Arrays.sort(nums);
		int index = 1;
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i < nums.length; i++) {
			if(nums[i-1] == nums[i]){
				set.add(nums[i]);
			}
		}
		return set;
	}
//	ά��һ��hashmap���������飬 ������ظ�ֵ�������set�С�
	public Set<Integer> find_duplicate2(int[] nums) {
		Map<Integer, Integer> hs = new HashMap<>();
		Set<Integer>set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if(!hs.containsValue(nums[i])){
				hs.put(i, nums[i]);	
			}else {
				set.add(nums[i]);
			}
		}
		return set;
	}
//	�������һ��O(1)�ռ�ķ������������飬���iλ�õ�Ԫ�ز�����i����ô�ͽ��б任;
 
	public Set<Integer> find_duplicate3(int[] nums) {
		Set<Integer> set = new HashSet<>();
		if(nums == null || nums.length == 0){
			return set;
		}
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] != i) {
				if(nums[i] == nums[nums[i]]){
					set.add(nums[i]);
					break;
				}
				int temp = nums[i];
				nums[i] = nums[temp];
				nums[temp] = temp;
			}
		}
		return set;
	}
	
	public static void main(String[] args) {
		 int[] nums = {2,3,1,0,2,5,3};
		 
		 System.out.println(new jianzhi_duplicateNumInArray_3().find_duplicate1(nums));
		 System.out.println(new jianzhi_duplicateNumInArray_3().find_duplicate2(nums));
		 System.out.println(new jianzhi_duplicateNumInArray_3().find_duplicate3(nums));
	}

}
