package com.leetcode;

public class Counting_Bits {
	
//ע�⵽ÿ������[2^k-1,z^k/2]�ⲿ���Ǻ�[2^k-2,2^k-1]��һ���ģ���[2^k-1,2^k]�ⲿ����[2^k-2,2^k-1]�ⲿ�ֵ�ÿ������һ��
	public int[] countBits(int num) {
		int[] res = new int[num+1];		
		if(num < 0 ){
			return res;
		}
		int base =1;
		res[0] = 0;
		while (base <= num) {
			int next = base * 2;
			for (int i = base; i < next && i <= num; i++) {
				res[i] = res[i - base] + 1;
			}
			base = next;
		}
		return res;
    }
	
	public static void main(String[] args) {
		int[] res = new Counting_Bits().countBits(13);
		for (int i : res) {
			System.out.println(i);
		}

	}

}
