package com.leetcode;

public class jianzhi_fibonacci_10 {

	public int fib(int n) {
		if(n == 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		int fibOne = 0;
		int fibTwo = 1;
		int fibN = 0;
		for(int i = 2; i<= n; i++){
			fibN = fibOne + fibTwo;
			fibTwo = fibOne;
			fibOne = fibN;
		}
		return fibN;
	}
	public static void main(String[] args) {
		 System.out.println(new jianzhi_fibonacci_10().fib(6));

	}

}
