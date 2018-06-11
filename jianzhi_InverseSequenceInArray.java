package com.leetcode;

public class jianzhi_InverseSequenceInArray {
	
	public int InversePairs(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }   
        int[] copy = new int[array.length];
        for(int i = 0; i < array.length; i++){
            copy[i] = array[i];
        }
        int count = guibingInverse(array, copy, 0, array.length-1);
        return count;
        
    }
    
    public int guibingInverse(int[] data, int[] copy, int start, int end){
        if(start == end){
            copy[start] = data[start];
            return 0;            
        }
        int length  = (end - start)/2;        
        int left = guibingInverse(copy,data, start, start + length);
        int right = guibingInverse(copy,data, start+length+1, end);
        
        int i = start +length;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while(i >= start && j >= start + length +1 ){
            if(data[i] > data[j]){                
                copy[indexCopy--] = data[i--];
                count += j -length -start;
            }else{
                copy[indexCopy--] = data[j--];
            }
        }
        
        for(; i>= start; i--){
            copy[indexCopy -- ] = data[i];
        }
        for(; j>= start + length + 1; j--){
            copy[indexCopy -- ] = data[j];
        }
        
        return count + left + right;
    }    
	
	public static void main(String[] args) {
		int[] array = {2,5,72,8,6,3};
		System.out.println(new jianzhi_InverseSequenceInArray().InversePairs(array));
	}

}
