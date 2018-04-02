package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class course_schedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if(numCourses <= 0){
			return false;
		}
		if(prerequisites == null || prerequisites.length == 0){
			return true;
		}
		int[] inDegree = new int[numCourses];
//		遍历顶点，计算各个顶点的入度值
		for (int[] edge : prerequisites) {
			inDegree[edge[0]]++;
		}
		List<Integer> res = new  ArrayList<>();
		Queue<Integer>queue = new LinkedList<>();
		
		for(int i = 0 ; i < inDegree.length ;i++){
			if(inDegree[i] == 0 ){
				queue.offer(inDegree[i]);
			}
		}
		while (!queue.isEmpty()) {
			int source = queue.poll();
			res.add(source);
			
		}
    }
	public static void main(String[] args) {
		 

	}

}
