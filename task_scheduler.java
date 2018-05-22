package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class task_scheduler {
	
	
	public int leastInterval(char[] tasks, int n) {
		Map<Character, Integer>map = new HashMap<>();
		int res = 0;
		
		for(char c:tasks){
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}		
		}	
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		
		for(char c:map.keySet()){
			queue.add(map.get(c));
		}
		
		while (!queue.isEmpty()) {
			int cnt = 0;
			List<Integer> list = new ArrayList<>();
			
			for(int i =0 ; i < n+1; i++){
				if(!queue.isEmpty()){
					list.add(queue.peek());
					queue.poll();
					++cnt;
				}
			}
			
			for(Integer integer:list){
				if(--integer > 0){
					queue.add(integer);
				}
			}
			res += queue.isEmpty()?cnt:n+1;									
		}
		return res;								
    }
	
	
	public static void main(String[] args) {
		char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
 
		System.out.println(new task_scheduler().leastInterval(tasks, 2));

	}

}
