package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class group_anagrams {
	
//	����һ����ÿ���ַ���תΪchar���飬��ʹ��arrays.sort()��char����������תΪString���ͽ��бȽϡ���һ��hashmap��(String ,List<String>)���͡�
	public List<List<String>> groupAnagrams_1(String[] strs) {
		HashMap<String, List<String>> hs = new HashMap<>();
        for (String string : strs) {
			char[] str = string.toCharArray();
			Arrays.sort(str);
			String temp = String.valueOf(str);
			if(!hs.containsKey(temp)){
				hs.put(temp, new ArrayList<>());
			}
			hs.get(temp).add(string);
		}
        return new ArrayList<>(hs.values());
    }
	
	public List<List<String>> groupAnagrams_2(String[] strs) {
		
		int[] count = new int[26];
		HashMap<String, List<String>> hs = new HashMap<>();
		for (String string : strs) {
			char[] str = string.toCharArray();
			Arrays.fill(count, 0);
			for (char c : str) {
				count[c-'a']++;
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < 26; i++){
				sb.append('#');
				sb.append(count[i]);
			}
			String key = sb.toString();
			if(!hs.containsKey(key)){
				hs.put(key, new ArrayList<>());
			}
			hs.get(key).add(string);
		}
		return new ArrayList<>(hs.values());
	}
	
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> list = new group_anagrams().groupAnagrams_2(strs);
		for (List<String> list2 : list) {
			for (String string : list2) {
				System.out.println(string);
			}
			System.out.println("----");
		}
	}
}
