/* Two brothers want to play a game, 
The rules of the game are: one player gives two sorted lists of 
numerical elements and a number (sum). 
The opponent has to find the closest pair of elements 
to the given sum.
-> pair consists of elements from each list

Please help those brothers to develop a program, that takes 
two sorted lists as input and return a pair as output.

Input Format:
-------------
size of list_1
list_1 values
size of list_2
list_2 values
closest number

Output Format:
--------------
comma-separated pair

Sample Input-1:
---------------
4
1 4 5 7
4
10 20 30 40
32
Sample Output-1
---------------
1,30

Sample Input-2
---------------
3
2 4 6
4
5 7 11 13
15

*/
import java.util.*;
class ClosestPair
{
	void printClosest(int ar1[], int ar2[], int m, int n, int x)
	{
		int diff = Integer.MAX_VALUE;
		int res_l = 0, res_r = 0;
		int l = 0, r = n-1;
		while (l<m && r>=0)
		{
		if (Math.abs(ar1[l] + ar2[r] - x) < diff)
		{
			res_l = l;
			res_r = r;
			diff = Math.abs(ar1[l] + ar2[r] - x);
		}
		if (ar1[l] + ar2[r] > x)
			r--;
		else 
			l++;
		}
		System.out.print("The closest pair is [" + ar1[res_l] +
						", " + ar2[res_r] + "]");
	}
	public static void main(String args[])
	{
		ClosestPair ob = new ClosestPair();
		Scanner sc=new Scanner(System.in);
		int n1=sc.nextInt();
        int arr1[]=new int[n1];
        for(int i=0;i<n1;i++)
          {
           arr1[i]=sc.nextInt();
          }
        int n2=sc.nextInt();
        int arr2[]=new int[n2];
        for(int i=0;i<n2;i++)
          {
           arr2[i]=sc.nextInt();
          }
        int x=sc.nextInt();
		ob.printClosest(arr1, arr2, n1, n2, x);
	}
}
/*
***** Testcases *****
case =1
input =4
1 8 10 12
4
2 4 9 15
11
output =1, 9

case =2
input =4
11 81 101 121
4
21 41 91 151
111
output =11, 91

case =3
input =7
11 25 55 81 101 111 121
6
21 30 41 71 91 151
161
output =11, 151

case =4
input =9
1 12 32 47 55 81 101 111 112 
8
2 13 21 30 41 71 81 141
71
output =1, 71

case =5
input =8
9 12 22 37 54 81 99 110
8
12 13 20 30 31 70 81 141
67
output=37, 30

*/