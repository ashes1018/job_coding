package com.leetcode;

public class Hamming_Distance {
	
	
//	先对两个数进行异或操作，得到两个数异或之后的结果。对该结果，对每位与1进行与操作，即可得到相异的位数。利用了二进制数不同则对应位置相异为1的性质。
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
