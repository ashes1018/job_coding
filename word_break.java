package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class word_break {
	
	
	public boolean wordBreak(String s, List<String> wordDict) {
		if(s == null || s.length() ==0 ){
			return true;
		}
		boolean[] res = new boolean[s.length()+1];
		res[0] = true;
		for (int i = 1; i <= s.length(); i++) {			
			for (int j = 0; j < i ; j++) {
				String tmp = s.substring(j, i);
				if(res[j] && wordDict.contains(tmp)){
					res[i] = true;
					break;
				}				
			}			
		}
		return res[s.length()];
	}
	
	
	
	public static void main(String[] args) {
		 String string = "leetcode";
		 List<String> wordDict = new ArrayList<>();
		 wordDict.add("leet");
		 wordDict.add("code");
		 System.out.println(new word_break().wordBreak(string, wordDict));
	}
}
