/* Given an integer array of nums and an integer X(Window size -1), 
return true if there are duplicate values (nums[i]== nums[j])in that Window(X)
X size is always <= abs(i - j)    where i and j are two two 
distinct indices of array.

Sample Input/output
------------------
input:
--------------
array size
array elements
X   
output:
-----------
true

Example 1:
Input: 4            
1 2 3 1  
3       
Output: true

case 2:
Input: 6
1 2 3 1 2 3
2
Output: false
*/
import java.util.*;
class DupWindow 
{
	public static void main(String[] args) 
	{
      Scanner sc=new Scanner(System.in);
       int n=sc.nextInt();
		int arr[]=new int[n];
       for(int i=0;i<n;i++)    
        arr[i]=sc.nextInt();
      //int arr[]={1,2,3,4,1,6,7,7};
		int k=sc.nextInt();
		System.out.println(dupli(arr,k));
	}
	public static boolean dupli(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
			System.out.println("Start: "+set);
            if(i > k) {set.remove(nums[i-k-1]);
			System.out.println(set +"i"+i);
			//System.out.println("arr"+Arrays.toString(nums));
			};
            if(!set.add(nums[i])) {
				System.out.println(set+"i"+i);
				//System.out.println("arr"+Arrays.toString(nums));
				return true;}
        }
        return false;
 }
}

/*
Testcases:
case=1
input=4
1 2 3 1
3
output=true

case=2
input=6
1 2 3 1 2 3
2
output=false

case=3
input=5
1 0 1 1 2
1
output=true

case=4
input=9
1 2 3 1 2 3 1 2 3
2
output=false

case=5
input=7
1 0 1 1 2 1 3
2
output=true
*/