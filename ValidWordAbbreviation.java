/*The Valid shortcuts of a string "abcd", are as follows:
abcd, abcd, a1cd, ab1d, abc1, 2cd, a2d, ab2, 1b1d, 1bc1,a1c1, 
1b2, 2c1, 3d, a3, 4

You are given a string S and shortcut string  SC, 
Your task is to find out whether the string matches with the 
given shortcut or not.
if matched print true, else false.

Note:
String S contains only lowercase letters and String SC contains 
only lowercase letters and digits.

Input Format:
-------------
Two space separated Strings S and SC

Output Format:
--------------
Print a boolean value


Sample Input-1:
---------------
internationalization i12iz4n

Sample Output-1:
----------------
true

Sample Input-2:
---------------
apple a2e

Sample Output-2:
----------------
false
*/


/* *************Solution********************** */

import java.util.*;

class ValidWordAbbreviation{
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                ++i;++j;
                continue;
            }
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                ++j;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
        }
        return i == word.length() && j == abbr.length();
    }
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		String t=sc.next();
		System.out.println(new ValidWordAbbreviation().validWordAbbreviation(s,t));
	}
}


/* **** Testcases *****
case =1
input =internationalization i12iz4n
output =true

case =2
input =apple a2e
output =false

case =3
input =testcase t2t2se
output =true

case =4
input =testcase t2t3se
output =false

case =5
input =internationalization i12iz5n
output =false

case =6
input =apple a1p1e
output =true

case =7
input =problemisvalidwordabbreviation p2b10w11t2n
output =true

case =8
input =problemisvalidwordabbreviation p2b10w10t2n
output =false

case =9
input =researchisthefoundationofanynation r12f8no9
output =false

case =10
input =kmitiscommittedtolongtermresearch  k10t9e10h
output =false

case =11
input =studentsareevaluatedonacontinuousbasis s19on14is
output =true

case =12
input =eachsemesterprovidingaminimumofseventeenweeksofinstructions e57s
output =true

case =13
input =kmitrules kmit6s
output =false
*/

