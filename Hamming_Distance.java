package com.leetcode;

public class Hamming_Distance {
	
	public int hammingDistance(int x, int y) {
		int xor = x^y;
		int count = 0;
		for(int i = 0; i < 32; i++){
			count += (xor >> i) & 1;
		}
		return count;
    }
		
	public static void main(String[] args) {
		System.out.println(new Hamming_Distance().hammingDistance(1, 4));

	}

}
