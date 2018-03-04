package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class permutations {
	
	public ArrayList<ArrayList<Integer>> permute(int[] nums) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		boolean[] isVisited = new boolean[nums.length];
		if(nums == null || nums.length == 0){
			return res;
		}
        solve(nums, res, list, isVisited);
        return res;
    }
	
	public void solve(int[] nums,ArrayList<ArrayList<Integer>> res, ArrayList<Integer>list, boolean[] isVisited) {
		if(list.size() == nums.length){
//			类型强转，还是不明白为什么
			res.add(new ArrayList<Integer>(list));	
//			res.add(list);							
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if(!isVisited[i]){
				list.add(nums[i]);
				isVisited[i] = true;
				solve(nums, res, list, isVisited);
				list.remove(list.size()-1);
				isVisited[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		 int[] nums = {1,2,3};
		 ArrayList<ArrayList<Integer>> res = new permutations().permute(nums);
		 for (List<Integer> list : res) {
			for (Integer integer : list) {
				System.out.println(integer);
			}
			System.out.println("---------");
		}

	}

}
