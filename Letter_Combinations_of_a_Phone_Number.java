package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number {
	
	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<>();
		if (digits == null){
			return result;
		}
		StringBuilder current = new StringBuilder();		
		String[] keyboard = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz",""};				
		int index = 0;
		buildResult(digits, index, current, keyboard, result);		
		return result;
		}
	
	public void buildResult(String digits, int index, StringBuilder current, String[]keyboard, ArrayList<String> result) {
		if(index == digits.length()){	
			result.add(current.toString());	
			return;
		}
	    int num = digits.charAt(index)-'0';
	    
		for(int i = 0; i < keyboard[num].length(); i++){
			current.append(keyboard[num].charAt(i));
			buildResult(digits, index+1, current, keyboard, result);			
			current.deleteCharAt(current.length()-1);
			}
		}
	    
	public static void main(String[] args) {
		 String digits = "";
		 ArrayList<String> list = new ArrayList<>();		 
		 list = new Letter_Combinations_of_a_Phone_Number().letterCombinations(digits);
		 System.out.println(list.size());
		 for (String string : list) {
			System.out.println(string);
		}		 
	}
}
