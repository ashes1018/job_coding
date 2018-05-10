package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Find_All_Numbers_Disappeared_in_an_Array {

	public List<Integer> findDisappearedNumbers(int[] nums) {
		Set<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		for(int i = 0 ; i < nums.length; i++){			
				set.add(nums[i]);
			}
		
		int index = 1;
		for(int i =0 ;i < nums.length; i++,index ++){
			if(!set.contains(index)){
				list.add(index);
			}
		}
		return list;
    }
	
	
	public List<Integer> findDisappearedNumbers_2(int[] nums) {
		for(int i = 0; i< nums.length; i++){
			int val = Math.abs(nums[i])-1;
			if(nums[val] > 0){
				nums[val] = -nums[val];
			}
		}
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i< nums.length; i++){
			if(nums[i] > 0){
				list.add(i+1);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(new Find_All_Numbers_Disappeared_in_an_Array().findDisappearedNumbers(nums));
		System.out.println(new Find_All_Numbers_Disappeared_in_an_Array().findDisappearedNumbers_2(nums));
	}
}
