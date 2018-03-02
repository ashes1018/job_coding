package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combination_sum {
	
//	这里用的是回溯的思想，但是有两个地方不是很明白
	 ArrayList<ArrayList<Integer>> ans = new ArrayList<>();	
	 public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		 Arrays.sort(candidates);
		 ArrayList<Integer>list = new ArrayList<>();
		 back_track(list, candidates, 0, target);
		 return ans;	        
	 }
	 
	 public void back_track(ArrayList<Integer>list, int[] candidates, int from,int target) {
		if(target == 0){
//			这里为什么要强转一下类型？
			ArrayList<Integer> list2 = new ArrayList<>(list);
			ans.add(list2);			
		}
		else{
			for (int i = from; i < candidates.length && candidates[i] <= target; i++) {				
				list.add(candidates[i]);
				back_track(list, candidates, i, target-candidates[i]);
//				这里为什么要强转类型？
				list.remove(new Integer(candidates[i]));
			}
		}		
	}
	
	 
	 
//	 再用DFS+递归的算法解答	 
	 public void dfs(int[] candidates, int target, int currentIndex, int count, List<Integer>list, List<List<Integer>> cur) {
		if(count >= target){
			if(count == target && !cur.contains(new ArrayList<>(list))){
				cur.add(new ArrayList<>(list));
			return;
			}
		}
		else {
			for(int i = currentIndex; i < candidates.length && count < target; i++){
				if(count + candidates[i] > target){
					break;
				}
				list.add(candidates[i]);
//				由于可以使用重复的值，所以在这里不是i+1，而是i
				dfs(candidates, target, i, count+candidates[i], list, cur);
				list.remove(list.size()-1);
			}
		}
	}
	
	public List<List<Integer>> combination_sum_dfs(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		dfs(candidates, target, 0, 0, list, res);
		return res;
	}
	 
	 
	 
	public static void main(String[] args) {
		 int[] nums = {2,3,6,7};
//		 回溯方法
		 System.out.println("回溯方法");
		 ArrayList<ArrayList<Integer>> ans = new combination_sum().combinationSum(nums, 7);
		 System.out.println(ans.size());
		 for (ArrayList<Integer> arrayList : ans) {
			 for (Integer integer : arrayList) {
				System.out.println(integer);
			}
		}
		 
//		 DFS+递归方法
		 System.out.println("DFS+递归方法");
		 List<List<Integer>> res = new combination_sum().combination_sum_dfs(nums, 7);
		 System.out.println("size:"+res.size());
		 for (List<Integer> arrayList : res) {
			for (Integer integer : arrayList) {
				System.out.println(integer);
			}
		}
	}
}
