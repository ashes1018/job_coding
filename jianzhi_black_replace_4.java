package com.leetcode;

public class jianzhi_black_replace_4 {

	public String replaceBlank(String string) {
		if(string == null || string.length() == 0){
			return string;
		}
		int originalLength = string.length() ;
		int numOfBlank = 0;
		for (int i = 0; i < string.length(); i++) {
			if(string.charAt(i) == ' '){
				numOfBlank ++;
			}
		}
		int newLength = originalLength + numOfBlank * 2;
		
		int indexOfNew = newLength -1;
		int indexOfOriginal = originalLength - 1;
		char[] arr = string.toCharArray();
		while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal) {
			if(arr[indexOfOriginal] == ' '){
				arr[indexOfNew--] = '0';
				arr[indexOfNew--] = '2';
				arr[indexOfNew--] = '%';
			}
			else {
				arr[indexOfNew--] = arr[indexOfOriginal];
			}
			indexOfOriginal--;
		}
		String str = arr.toString();
		return str;
	}
	
	public static void main(String[] args) {
		 String string = "we are happy";
		 System.out.println(new jianzhi_black_replace_4().replaceBlank(string));
		 
	}

}
