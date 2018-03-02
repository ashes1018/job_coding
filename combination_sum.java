package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combination_sum {
	
//	�����õ��ǻ��ݵ�˼�룬�����������ط����Ǻ�����
	 ArrayList<ArrayList<Integer>> ans = new ArrayList<>();	
	 public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		 Arrays.sort(candidates);
		 ArrayList<Integer>list = new ArrayList<>();
		 back_track(list, candidates, 0, target);
		 return ans;	        
	 }
	 
	 public void back_track(ArrayList<Integer>list, int[] candidates, int from,int target) {
		if(target == 0){
//			����ΪʲôҪǿתһ�����ͣ�
			ArrayList<Integer> list2 = new ArrayList<>(list);
			ans.add(list2);			
		}
		else{
			for (int i = from; i < candidates.length && candidates[i] <= target; i++) {				
				list.add(candidates[i]);
				back_track(list, candidates, i, target-candidates[i]);
//				����ΪʲôҪǿת���ͣ�
				list.remove(new Integer(candidates[i]));
			}
		}		
	}
	
	 
	 
//	 ����DFS+�ݹ���㷨���	 
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
//				���ڿ���ʹ���ظ���ֵ�����������ﲻ��i+1������i
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
//		 ���ݷ���
		 System.out.println("���ݷ���");
		 ArrayList<ArrayList<Integer>> ans = new combination_sum().combinationSum(nums, 7);
		 System.out.println(ans.size());
		 for (ArrayList<Integer> arrayList : ans) {
			 for (Integer integer : arrayList) {
				System.out.println(integer);
			}
		}
		 
//		 DFS+�ݹ鷽��
		 System.out.println("DFS+�ݹ鷽��");
		 List<List<Integer>> res = new combination_sum().combination_sum_dfs(nums, 7);
		 System.out.println("size:"+res.size());
		 for (List<Integer> arrayList : res) {
			for (Integer integer : arrayList) {
				System.out.println(integer);
			}
		}
	}
}
