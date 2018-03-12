package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets {
	
	
//	subset思路和之前的dfs递归是一样的。
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		if(nums.length == 0 || nums == null){
			return res;
		}
		subsets_dfs(nums, 0, list, res);
		return res;
    }
	
	public void subsets_dfs(int[] nums, int index,List<Integer> list, List<List<Integer>> res) {
		res.add(new ArrayList<>(list));
		for (int i = index; i < nums.length; i++) {		
			list.add(nums[i]);
			subsets_dfs(nums, i+1, list, res);
			list.remove(list.size()-1);
		}
	}
	
//	在有重复值的情况下
	public List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		
		if(nums.length == 0 || nums == null){
			return res;
		}
//		需要先对数组排序，保证可以跳过重复值
		Arrays.sort(nums);
		subsets2_dfs(nums, 0, list, res);
		return res;
	}
	
	public void subsets2_dfs(int[] nums, int index,List<Integer> list, List<List<Integer>> res) {
		res.add(new ArrayList<>(list));
		for (int i = index; i < nums.length; i++) {
//			跳过重复值。
			if(i > index && nums[i] == nums[i-1]){
				continue;
			}
			list.add(nums[i]);
			subsets2_dfs(nums, i+1, list, res);
			list.remove(list.size() - 1);
		}		
	}
	
	
	public static void main(String[] args) {
		 int[] nums = {1,2,2};
		 System.out.println(new subsets().subsets2(nums));
		 System.out.println(new subsets().subsets(nums));
	}

}
