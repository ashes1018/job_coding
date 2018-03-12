package com.leetcode;

import java.util.HashMap;

public class minimum_window_substring {

	
	public String minWindow(String s, String t) {
		HashMap<Character, Integer> hs = new HashMap<>();
		
//		将t中所有的字符存入hashmap中
		for(int i = 0 ; i< t.length(); i++){
			if(!hs.containsKey(t.charAt(i))){
				hs.put(t.charAt(i), 1);
			}else {
				hs.put(t.charAt(i), hs.get(t.charAt(i))+1);
			}
		}
		
		int count = 0;
		int pre = 0;
		for (int i = 0; i < s.length(); i++) {
			if(hs.containsKey(s.charAt(i))){
				hs.put(s.charAt(i), hs.get(s.charAt(i))-1);
//				if(hs.get(s.charAt(i)) >= 0){
//					count ++;
//				}
				count++;
			}
			
			while (count == t.length()) {
				if(hs.containsKey(s.charAt(pre))){
					hs.put(s.charAt(pre), hs.get(s.charAt(pre)+1));
				}
			}
		}
		
    }
	
	public static void main(String[] args) {
		 

	}

}
