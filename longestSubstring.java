package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class longestSubstring {
	 public int lengthOfLongestSubstring(String s) {
	        int n = s.length();
	        int i = 0;
	        int j = 0;
	        int max_length = 0;
	        Set<Character> set = new HashSet();
	        while(i < n && j < n){
	            if(!set.contains(s.charAt(j))){
	                set.add(s.charAt(j));
	                max_length = Math.max(max_length, j-i+1);                
	                ++j;
	            }else{
	                set.remove(i);
	                ++i;
	            }	           
	        	}
	        return max_length;
	}
	 public static void main(String[] args) {
		System.out.println(new longestSubstring().lengthOfLongestSubstring("pwwkew"));
	}
}
