/* Given a string s, .reverse only all the vowels in the 
string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can 
appear in both lower and upper cases, more than once.

Example 1:
Input: hello
Output: holle


Example 2:
Input: Keshavmemorial
Output: Kashivmomerael

Example 3:
Input: variations
Output: voriatians

*/
import java.util.*;
class ReverseVowels {    
    public String reverseVowels(String s) {    
        StringBuilder tr = new StringBuilder();        
        int right = s.length()-1;        
        int left = 0;        
        while(left < s.length()){            
            if(isVowel(s.charAt(left))){                
                while(!isVowel(s.charAt(right))){                    
                    right--;                    
                }                
                tr.append(s.charAt(right));                
                right--;                
            }else{                
                tr.append(s.charAt(left));                
            }            
            left++;            
        }        
        return tr.toString();        
    }
    Boolean isVowel(char c){        
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') return true;
        return false;                
    }    
	public static void main(String args[])
	{
		Scanner sc =new Scanner(System.in);
		String st=sc.next();
		System.out.println(new ReverseVowels().reverseVowels(st));

	}
}