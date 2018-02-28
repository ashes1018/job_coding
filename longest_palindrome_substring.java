package com.leetcode;

public class longest_palindrome_substring {
//	 public String longestPalindrome(String s) {
//	        int max_length = 0;
//	        if(s.length() == 0){
//	            return null;
//	        }
//	        if(s.length() == 1){
//	            return s;
//	        }
//	        String str = "";
//	        String max_str = "";
//	        int count = 0 ;
//	        for(int i = 0; i < s.length()-1; i++){            
//	            for(int j = i+1 ; j < s.length(); j ++){                            
//	                if(isPalindrome(s.substring(i,j+1))){	                    
//	                        str = s.substring(i,j+1);
//	                        count ++;
//	                        if(str.length() > max_length){
//	                        	max_str = str;	        
//	                        	max_length = str.length();
//	                    }
//	                }
//	            }
//	        }
//	        if(count == 0){
//	        	return String.valueOf(s.charAt(0));
//	        }
//	        return max_str;
//	    }
//	    
//	    
//	    public boolean isPalindrome(String s){
//	        int n = s.length();
//	        for(int i = 0 ; i < n/2;i++){
//	            if(s.charAt(i) == s.charAt(n-i-1)){
//	                continue;
//	            }else{
//	                return false;
//	            }
//	        }
//	        return true;
//	    }
//	    public static void main(String[] args) {
//			System.out.println(new longest_palindrome_substring().longestPalindrome("klvxwqyzugrdoaccdafdfrvxiowkcuedfhoixzipxrkzbvpusslsgfjocvidnpsnkqdfnnzzawzsslwnvvjyoignsfbxkgrokzyusxikxumrxlzzrnbtrixxfioormoyyejashrowjqqzifacecvoruwkuessttlexvdptuvodoavsjaepvrfvbdhumtuvxufzzyowiswokioyjtzzmevttheeyjqcldllxvjraeyflthntsmipaoyjixygbtbvbnnrmlwwkeikhnnmlfspjgmcxwbjyhomfjdcnogqjviggklplpznfwjydkxzjkoskvqvnxfzdrsmooyciwulvtlmvnjbbmffureoilszlonibbcwfsjzguxqrjwypwrskhrttvnqoqisdfuifqnabzbvyzgbxfvmcomneykfmycevnrcsyqclamfxskmsxreptpxqxqidvjbuduktnwwoztvkuebfdigmjqfuolqzvjincchlmbrxpqgguwuyhrdtwqkdlqidlxzqktgzktihvlwsbysjeykiwokyqaskjjngovbagspyspeghutyoeahhgynzsyaszlirmlekpboywqdliumihwnsnwjc"));
//		}
	
	
 
		   public String isPalindrome(String s, int left, int right){
			
		       int len = s.length();
		       while(left >= 0 && right < len){
		           if(s.charAt(left) != s.charAt(right)){
		               break;
		           }else{
		               left --;
		               right++;
		           }
		       }       
		       return s.substring(left+1, right);
		   }
		    
		    public String longestPalindrome(String s){
		    	if(s == null){
		    		return null;
		    	}
		        String str = null;
		        int max_length = 0;
		        for(int i = 0 ; i < s.length(); i++){
		            String str1 =  isPalindrome(s,i,i+1);
		            String str2 =  isPalindrome(s,i,i);
		            if(str1.length() > max_length){
		                max_length = Math.max(str1.length(),max_length);
		                str = str1;
		            }
		            if(str2.length() > max_length){
		                max_length = Math.max(str2.length(),max_length);
		                str = str2;
		            }
		        }    
		        return  str;
		    }
		    
		    public static void main(String[] args) {
				System.out.println(new longest_palindrome_substring().longestPalindrome("ababa"));
			}
		}

 
