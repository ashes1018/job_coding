package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Find_All_Anagrams_in_a_String {
	
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();		
		int[] hash = new int[256];
		char[] pp = p.toCharArray();
		for(char i:pp){
			++hash[i];
		}
		int i = 0;
		int[] tmp = new int[256];
		
		int left = 0, right = 0, count = p.length();
		while (right < s.length()) {
			if(hash[s.charAt(right)] >= 1){
				count --;			
			}
			hash[s.charAt(right)]--;
			right++;
			if(count == 0){
				list.add(left);
			}
			if(right - left == p.length()){
				if(hash[s.charAt(left)] >= 0){
					count ++;
				}
				hash[]++;
			}
		}
						
		return list;
    }
	
		
	public static void main(String[] args) {
		 String s = "cbaebabacd";
		 String p = "abc";
		 List<Integer> list = new Find_All_Anagrams_in_a_String().findAnagrams(s, p);
//		 System.out.println(list.size());
		 for (Integer integer : list) {
			System.out.println(integer);
		}
	}

}