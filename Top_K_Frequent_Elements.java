package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Top_K_Frequent_Elements {

	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(!map.containsKey(nums[i])){
				map.put(nums[i], 1);
			}else {
				map.put(nums[i], map.get(nums[i])+1);
			}
		}
		
		List<Integer>[] bucket = new List[nums.length + 1];
		for(int key:map.keySet()){
			int count = map.get(key);
			if(bucket[count] == null){
				bucket[count] = new ArrayList<>();
			}
			bucket[count].add(key);
		}
		
		List<Integer> res = new ArrayList<>();
		for(int i = nums.length ; i>0;i--){
			if(bucket[i] != null && res.size() < k){
				res.addAll(bucket[i]);
			}
		}
		return res;
		
    }
	public static void main(String[] args) {
		 int[] nums = {1,1,1,2,2,3};
		 List<Integer> res = new Top_K_Frequent_Elements().topKFrequent(nums, 2);
		 for (Integer integer : res) {
			System.out.println(integer);
		}
	}

}
