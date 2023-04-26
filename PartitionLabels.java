/* You are given a string s. We want to partition the string into 
as many parts as possible so that each letter appears in at most 
one part.

Note that the partition is done so that after concatenating 
all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts. 

Example 1:
Input: ababcbacadefegdehijhklij
Output: [9, 7, 8]

Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

Example 2:
Input: eccbbbbdec
Output: [10]

Example 3:
Input: abacadcklmklmxyyzx
Output: [7, 6, 5]
*/

import java.util.*;
class PartitionLabels
{

	public List<Integer> partitionLabels(String s) 
	{
		HashMap<Character,Integer> my=new HashMap<>();
		ArrayList<Integer> ls=new ArrayList<>();
		int mx=Integer.MIN_VALUE;

		for(int i=0;i<s.length();i++){
			my.put(s.charAt(i),i);
		}

		int pos = -1;
		for(int i=0;i<s.length();i++)
		{
			Character ch=s.charAt(i);
			mx=Math.max(mx,my.get(ch));
			if(mx==i)
			{
				ls.add(i - pos);
				pos = i;
			}
		}
		return ls;
	}

	public List<Integer> partitionLabels2(String S) 
	{
        List<Integer> res = new ArrayList<>();
        
        int[] table = new int[26];
        char[] stc = S.toCharArray();

        for(char c:stc)	// count the occurence of each char in string
            table[c-'a']++;

		for (int ii = 0; ii < 26; ii++)
		{
			System.out.println(table [ii]);
		}
        
        int i = 0, j = 0, l = S.length(), counter = 0;
        HashSet<Character> hs = new HashSet<>();
        while(j < l)
		{
            char c = stc[j];
			// found new char in current window, so increase counter
            if(!hs.contains(c))
			{
                hs.add(c);
                counter++;
            }
            table[c-'a']--;
            j++;
			// decrease the counter as we have exhausted the c char and remove char c from set
            if(table[c-'a'] == 0){ 
                counter--;
                hs.remove(c);
            }
			// if counter becomes 0, means current window is a partition
            if(counter == 0)
			{
                res.add(j - i); // add length of current window
                i = j; // reset i for next window
            }            
        } 
        return res;
    }

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String st = sc.next();
		System.out.println(new PartitionLabels().partitionLabels(st));
	}

}