package com.leetcode;

import java.util.Stack;

public class Decode_String {

	
//	������ջ��һ�����ڱ����ַ��Ĵ�����һ�����ڱ����ַ�����������ۣ����������������š�[��ʱ���ַ�ջ������գ�����������������ʱ������ջ����ջ��
//	��ȡ������ͬʱ�����ַ�ջ��ջ��Ԫ�ء�
	public String decodeString(String s) {
		String res = "";		
		Stack<Integer> countStack = new Stack<>();
		Stack<String> resStack = new Stack<>();
		int i = 0;
		
		while (i <s.length()) {
			if(Character.isDigit(s.charAt(i))){
				int count = 0;
				while (Character.isDigit(s.charAt(i))) {
					count = count * 10 + (s.charAt(i) - '0');
					i++;
				}
				countStack.push(count);
			}else if (s.charAt(i) == '[') {
				resStack.push(res);
				res = "";
				i++;
			}else if(s.charAt(i) == ']'){
				StringBuffer sb = new StringBuffer(resStack.pop());
				int times = countStack.pop();
				for(int j = 0; j < times; j++){
					sb.append(res);
				}
				res = sb.toString();
				i++;
			}else {
				res += s.charAt(i);
				i++;
			}		
		}		
		return res;		 
    }
	
	public static void main(String[] args) {
		 System.out.println(new Decode_String().decodeString("3[a2[c]]"));

	}

}
