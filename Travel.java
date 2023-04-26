/*
Sri Vihaan Travels announced a family trip to Sri Nagar, for which they began 
taking reservations. They are only offering 2 and 3-seater tickets for this trip.

Each member of certain groups is identifiable by the group ID to which he or 
she belongs. Each group is uniquely identified by its group ID.

The travel administration decided that the ticket will only be issued to members of the same group. It is decided that No wasted tickets will be issued 
(i.e., If a person is alone, then he is not allowed to get a ticket).

You are given a list of integers person_id[], where person_id[i] is the group ID 
of the ith person in the list. Your objective is to determine whether fewer tickets 
should be issued to cover everyone in each group. Print -1, if it is not possible.


Input Format:
-------------
Line-1: Comma separated integers, Person's group-ID

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
1,1,3,2,2,2,1,2,2,3

Sample Output-1:
----------------
4

Explanation: 
------------
They can book the tickets for all the people, as follows:
- Issue the 3-seater ticket, to group with ID-1 of size 3.
- Issue the 2-seater ticket, to group with ID-3 of size 2.
- Issue the 3-seater ticket, to group with ID-2 of size 5.
- Issue the 2-seater ticket, to group with ID-2 of size 5.
So, you have issued 4 tickets in total.


Sample Input-2:
---------------
1,1,1,2,2,3

Sample Output-2:
----------------
-1

Explanation: 
------------
There is a group with ID-3 of size 1. 
The administration's ruling states that a single person cannot receive a ticket.
So, print -1.

*/

import java.util.*;

class Travel{
    public int minimumRounds(int[] A) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int a : A)
            count.put(a, count.getOrDefault(a, 0) + 1);
        int res = 0;
        for (int freq : count.values()) {
            if (freq == 1) return -1;
            res += (freq + 2) / 3;
        }
        return res;
    }
	public static void main(String args[]){
		Scanner sc= new Scanner(System.in);
		String list[]=sc.nextLine().split(",");
		int arr[]=new int[list.length];
		for(int i=0;i<list.length;i++)
			arr[i]=Integer.parseInt(list[i]);
		System.out.println(new Travel().minimumRounds(arr));
	}
}

/*

==== testcases ====
case =1
input =4,6,5,3,2,3,2,4,6,4,3,1,5,2,3,2,2,6,3,3,4,3,3,5,5,1,4,2,5,1,6,6,4,3,4,4,4,6,4,3,3,1,2,1,1,1,4,4,3,5
output =18

case =2
input =4,1,2,2,6,6,1,6,1,2,4,3,3,3,2,6,1,4,5,5,5,6,3,1,6,3,5,1,4,1,1,5,5,1,5,5,4,2,2,3,6,6,1,5,3,5,6,6,1,3,3,5,5,5,5,2,4,3,2,3,5,5,1,3,6,6,1,1,2,4,5,2,3,4,5
output =27

case =3
input =4,5,4,5,2,1,1,5,6,3,5,1,3,3,3,5,1,3,6,4,4,1,6,2,1,2,6,1,1,1,2,6,6,5,6,4,6,3,4,6,5,2,2,4,1,1,5,2,4,4,4,1,1,6,5,1,6,2,2,6,5,4,4,1,3,3,2,4,5,6,1,1,3,6,3
output =28

case =4
input =5,8,1,8,9,5,5,4,7,8,3,7,6,4,5,6,6,8,7,5,6,3,9,2,8,4,5,5,3,6,1,4,2,5,4,9,3,6,6,7,7,8,6,5,6,4,9,7,2,6,3,9,3,5,5,8,2,6,8,8,7,2,2,2,1,3,7,8,4,7,8,5,5,4,1,7,2,3,7,3,8,4,5,8,2,4,7,5,6,5,6,6,9,9,4,5,9,1,5,9,1,5,3,6,9,9,7,5,5,7,3,6,6,9,1,6,4,2,8,4,5,4,7,5,2,2,7,4,7,8,6,7,8,8,1,1,9,7,2,2,4,3,3,7,7,5,3,9,8,3,6,3,4,3,8,8,5,9,9,8,3,2,2,6,9,8,2,1,1,1,8,5,7,1,9,6,7,3,7,4,5,6,2,7,6,6,7,6,8,4,4,6,2,2,2,8,6,4,9,4,6,4,9,9,8,8,4,8,1,7,1,2,3,3,6,3,2,2,3,8,5,2,4,9,3,1,5,2,1,8,1,3,8,5,6,7,1,8,8,6,9,5,8,4,5,9,6,4,1,3
output =86

case =5
input =1,4,5,1,7,4,9,9,8,1,3,5,7,3,8,6,8,5,1,2,7,8,9,1,3,3,3,1,2,7,8,2,3,7,4,3,5,7,8,6,4,5,3,7,1,2,7,5,1,6,5,5,1,8,1,3,9,2,6,5,1,3,6,9,2,9,5,9,2,5,3,1,6,4,5,4,2,8,3,2,3,4,2,3,6,3,7,5,8,4,4,3,1,7,2,9,3,3,9,7,9,5,5,2,4,7,7,9,2,8,2,5,4,9,6,8,1,4,8,1,1,1,5,2,7,5,8,5,2,6,2,4,5,1,8,3,6,7,7,5,3,6,9,7,2,8,9,5,6,1,2,1,7,8,3,7,1,7,3,2,8,7,3,9,6,9,9,2,6,2,7,9,2,8,6,5,4,5,4,1,6,4,3,6,3,4,2,5,1,6,7,4,8,2,4,8,1,6,9,2,7,6,4,8,5,3,3,6,4,8,8,6,9,1,5,9,8,5,7,9,4,2,9,1,4,8,6,8,4,9,6,8,6,9,6,8,2,5,8,6,8,4,5,9,8,9,5,3,3,5
output =87

case =6
input =6,6,7,9,6,2,7,9,3,1,1,1,9,4,4,1,7,8,9,9,1,8,2,3,9,3,4,7,2,3,3,2,4,3,4,9,1,3,9,3,7,6,9,4,8,4,5,2,6,5,9,8,6,9,8,2,6,8,2,9,6,2,2,5,5,4,2,5,4,3,9,8,4,7,5,6,1,1,2,4,4,7,9,8,2,7,1,9,6,8,4,9,1,1,6,3,5,6,4,5,6,7,8,9,6,8,4,8,3,3,4,5,2,4,9,4,5,9,7,1,9,5,9,3,7,5,6,6,1,6,9,2,6,3,6,9,3,5,5,6,8,4,3,2,6,5,2,9,9,4,1,8,3,1,8,8,4,3,4,6,7,2,8,8,7,1,5,1,9,7,6,9,3,7,4,8,1,5,3,8,9,6,1,3,3,2,2,3,5,5,2,9,2,1,4,1,5,3,6,1,3,2,3,6,7,4,4,1,3,5,7,3,9,7,6,8,9,8,8,8,5,6,2,8,4,5,5,9,7,3,4,2,9,8,3,4,1,2,5,7,4,2,8,1,4,6,7,5,7,7,2,7,1,5,8,8,4,5,5,3,5,8,4,5,7,9,9,6,5,6,8,3,5,4,3,3,1,2,7,9,6,6,3,2,8,6,1,9,1,3,6,4,7,4,9,8,5,1,7,1,9,7,5,8,6,4,2,3,9,2,6,5,7,4,9,6,9,6,1,1,3,1,1,7,4,4,8,1,3,1,8,8,7,6,6,5,1,2,4,4,3,7,7,7,2,8,1,1,9,8,1,9,1,9,7,3,6,9,2,5,1,4,4,1,2,4,1,4,2,6,6,5,3,3,8,1,3,3,9,2,7,2,3,3,7,3,5,5,2,4,2,9,6,3,5,6,7,4,5,6,6,8,8,4,6,6,2,2,7,5,9,5,5,4,6,6,1,3,7,5,9,9,8,2,8,7,4,9,4,6,4,7,9,8,7,1,1,1,2,2,5,3,1,1,1,6,5,9,3,7,9,1,6,2,2,2,2,3,9,1,4,6,1,6,2,4,7,1,7,7,1,3,7,9,7,1,1,1,8,6,9,9,7,6,7,7,8,8,5,6,6,7,8,5,8,3,5,6,3,5
output =170

case =7
input =2,6,7,5,3,8,6,7,4,9,8,4,9,3,2,1,1,9,2,2,6,5,4,2,3,7,8,4,6,7,8,1,2,1,5,9,7,7,4,2,4,7,2,6,9,4,8,6,7,5,4,5,9,9,4,8,8,5,3,1,1,7,4,3,2,1,7,3,8,1,3,3,1,4,9,1,1,1,4,6,8,5,4,3,1,1,7,5,3,2,1,9,4,5,8,6,8,9,3,5,4,2,8,8,1,8,6,7,9,7,3,5,7,8,6,2,9,7,7,5,4,5,4,6,7,3,4,3,3,8,2,4,7,1,1,8,6,6,8,2,8,6,8,6,3,7,1,2,5,5,5,2,5,2,1,2,8,9,5,5,8,2,8,5,9,2,6,1,9,4,9,9,6,9,9,9,2,3,8,9,7,5,9,9,5,4,4,7,2,8,2,5,8,1,1,3,7,7,5,9,7,1,9,5,2,7,8,6,6,1,8,5,1,5,2,5,3,5,2,1,9,6,9,4,1,2,1,9,5,7,6,6,2,8,9,6,9,4,1,8,9,7,1,5,9,8,3,7,3,8,9,7,3,5,8,6,2,5,6,4,3,5,6,6,9,4,2,6,1,7,8,3,1,2,2,8,1,9,2,6,3,9,4,5,6,9,4,1,3,7,6,5,3,6,7,6,3,3,2,9,4,7,3,7,7,5,6,1,1,6,5,6,4,3,1,2,1,5,2,6,2,7,5,5,7,5,5,6,3,5,2,5,8,7,8,8,6,7,3,3,9,7,1,2,1,2,4,4,2,4,3,1,5,5,6,2,2,1,2,9,5,9,2,9,1,2,8,3,9,2,8,3,2,4,9,5,4,2,6,4,3,3,1,3,3,8,8,5,1,2,3,7,5,1,7,9,7,2,7,2,4,4,1,8,1,5,3,4,9,4,9,5,6,9,5,6,5,1,6,8,3,6,7,2,9,9,2,4,2,1,4,1,4,6,8,5,6,2,5,7,6,2,4,8,9,6,1,3,5,3,9,4,1,7,3,8,7,1,8,4,7,4,3,1,9,3,6,7,4,3,8,6,2,6,4,9,6,9,5,2,5,8,2,9,8,9,9,1,3,8,1,4,1,8,8,9,2,8,7,2,6,4,4,6,4,2,6,4,5,2,7,2,1,2,5,7,4,9,4,1,4,2,7,4,3,2,5,5,3,8,4,6,9,1,3,4,6,9,4,6,2,2,3,9,7,4,8,7,1,3,9,4,8,6,2,2,5,4,2,4,9,9,4,5,9,4,3,4,1,5,4,5,7,9,9,6,6,1,8,5,9,6,3,7,7,2,2,4,4,8,2,8,8,6,9,8,8,5,2,5,5,3,4,3,2,1,6,2,5,1,8,9,6,8,6,4,5,5,8,4,5,3,2,6,5,2,5,9,3,1,5,2,2,9,9,9,5,5,3,6,4,6,6,9,1,1,4,3,8,6,6,7,1,5,4,4,9,8,1,3,7,7,8,7,3,7,4,6,8,8,3,1,5,2,3,5,1,5,7,2,2,3,9,8,4,1,7,4,9,4,6,1,8,7,8,7,5,4,3,5,2,5,2,6,5,6,5,7,9,5,5,7,1,2,4,2,5,8,3,3,1,6,6,9,8,5,8,3,9,3,2,9,9,4,4,4,8,8,7,9,6,6,8,4,9,5,5,6,9,3,3,3,9,5,5,2,4,1,4,5,4,4,9,9,8,8,5,8,3,7,5,5,5,2,4,6,6,4,6,1,9,9,8,3,5,1,6,6,5,7,1,4,4,8,5,5,2,4,5,8,9,9,9,9,6,8,2,8,5,8,7,8,8,8,5,3,8,3,5,5,3,9,8,2,9,3,9,5,2,9,3,5,5,6,3,1,6,7,8,9,3,5,3,5,9,2,4,7,3,7,2,6,6,9,7,2,8,5,3,9,5,5,1,8,2,5,2,3,5,3,3,4,2,7,2,7,3,6,1,5,3,3,5,4,1,8,4,7,2,3,5,8,7,8,6,2,5,2,7,3,1,7,9,1,8,4,1,6,8,4,7,8,6,1,2,7,7,2,3,4,3,7,2,7,2,6,3,6,6,8,5,9,6,9,9,6,2,5,4,7,5,6,7,5,5,4,4,5,8,5,5,1,9,9,9,8,7,4,4,6,6,5,3,1,9,1,6,9,5,9,9,1,9,5,4,4,4,2,8,3,5,8,2,4,6,5,8,1,6,1,7,4,6,3,1,2,3,9,7,9
output =337

case =8
input =2,7,8,4,1,4,2,3,4,9,1,1,4,3,6,8,9,8,2,7,7,4,6,3,7,4,7,6,4,8,9,1,6,8,9,4,6,3,6,8,8,5,7,8,4,8,2,4,6,6,2,9,6,9,4,9,7,5,3,3,9,9,3,7,5,6,5,7,4,6,8,7,2,1,8,8,6,1,6,7,8,2,7,1,9,9,1,6,1,4,5,8,3,4,9,5,6,1,5,4,8,6,4,3,8,4,4,5,6,5,4,9,1,6,1,1,2,3,5,5,6,6,6,3,2,1,5,1,4,7,7,1,1,4,3,7,7,4,1,6,6,6,6,3,3,2,2,2,7,7,5,9,3,4,5,4,8,2,8,8,8,8,5,2,3,1,9,8,9,5,5,6,6,8,4,8,7,1,8,9,3,9,3,7,4,8,2,4,6,7,8,6,5,7,8,8,8,8,2,7,3,4,7,1,7,3,6,4,6,7,6,7,4,6,6,7,6,3,7,3,6,3,2,5,4,3,9,4,9,8,4,2,6,9,8,9,9,7,1,3,2,7,7,3,1,6,4,4,1,8,9,3,8,7,2,3,3,8,7,2,9,3,9,3,7,9,1,3,3,2,6,6,1,5,3,2,9,8,6,1,3,1,2,6,4,9,5,9,5,2,9,1,2,1,7,3,3,1,4,3,2,8,1,5,4,1,7,2,5,7,3,3,1,6,8,6,8,5,2,5,6,7,9,2,4,6,2,3,1,9,9,8,1,7,1,9,7,8,4,9,9,2,1,3,5,2,8,8,3,5,6,4,8,6,3,4,1,6,7,8,4,9,8,4,8,4,4,7,4,8,7,6,2,5,8,3,4,9,1,7,2,4,6,9,6,5,6,3,9,5,7,3,4,8,6,9,1,4,8,5,3,5,6,8,9,1,6,1,4,3,3,8,8,3,7,9,2,1,2,6,5,1,4,9,8,2,6,3,9,7,1,4,6,4,3,5,4,2,4,1,4,2,2,4,4,5,6,1,9,6,7,9,1,5,8,8,7,9,2,7,7,3,3,7,6,2,5,9,9,6,5,1,9,5,3,7,8,2,4,8,6,5,2,2,6,1,3,2,7,5,8,5,4,8,9,2,2,2,2,8,1,7,7,3,6,1,1,5,6,8,4,1,7,9,6,4,5,2,9,3,7,9,5,6,7,6,7,6,8,9,2,4,6,4,7,8,8,4,9,5,4,9,4,9,2,4,9,3,5,7,9,5,8,6,3,1,9,6,5,1,3,7,9,7,9,9,2,1,9,8,4,3,9,1,1,1,9,3,1,7,3,9,1,1,2,7,1,8,1,5,9,4,7,4,1,1,5,5,6,1,3,2,8,6,8,9,1,2,9,7,3,9,6,6,7,4,2,5,6,5,9,2,4,1,5,1,7,5,3,3,2,9,9,4,2,4,4,6,2,3,3,8,1,2,9,6,2,8,5,7,3,7,6,7,9,1,1,5,7,3,1,5,4,5,1,9,3,2,3,1,3,6,4,2,1,9,5,6,2,4,2,7,4,8,3,5,1,5,7,6,9,5,6,9,5,4,2,1,2,8,4,6,6,8,5,5,5,6,3,1,6,4,8,6,3,3,4,6,3,8,3,5,3,7,6,9,3,8,4,3,5,8,4,4,3,9,7,6,9,8,3,9,7,9,8,1,5,4,8,9,5,3,2,8,5,2,4,8,5,6,3,9,2,2,4,6,4,3,8,1,6,9,3,4,3,2,9,9,4,5,9,6,3,9,6,3,5,4,4,7,9,2,6,9,8,1,9,1,2,7,6,2,8,2,2,2,3,1,5,5,6,4,8,7,9,7,4,4,7,4,2,4,2,9,9,9,6,7,1,7,6,8,9,3,8,9,1,6,4,3,6,5,8,3,9,2,3,9,1,9,7,2,7,4,4,1,8,3,7,3,2,3,4,6,2,9,7,8,6,6,2,6,5,5,1,5,5,9,6,4,2,7,4,6,4,6,4,9,8,9,2,7,6,6,1,5,2,7,2,5,7,7,6,8,6,8,7,3,2,3,9,2,4,1,8,6,1,7,9,7,9,8,5,2,8,3,8,5,2,7,2,3,6,8,9,8,8,3,5,5,1,8,1,1,1,5,1,9,6,2,8,6,9,1,9,1,8,2,1,5,4,3,9,8,7,3,6,9,1,5,9,5,2,8,8,1,9,2,4,5,8,2,4,1,2,3,4,8,5,2,3,3,4,3,8,8,7,9,8,8,6,3,2,7,3,5,6,9,2,4,4,7,2,8,3,9,6,6,5,2,8,9,5,2,2,5,1,9,2,8,8,2,8,7,1,6,7,6,4,1,1,2,4,5,5,7,7,9,1,4,5,9,2,1,4,8,3,4,3,1,7,5,8,4,1,2,5,1,7,4,7,1,1,5,6,1,1,5,5,5,4,8,5,2,3,3,3,3,6,5,9,3,8,1,2,8,9,6,4,8,4,3,4,7,9,4,2,1,9,6,4,9,4,5,5,8,7,7,9,7,2,1,6,8,8,4,9,5,6,7,8,8,3,1,4,9,2,9,9,9,9,1,2,9,6,8,8,3,7,7,8,4,4,9,3,5,6,4,8,2,7,4,9,9,6,6,6,2,6,7,8,2,7,7,3,8,3,5,6,4,5,5,9,4,5,9,9,4,6,6,9,7,8,6,5,1,3,7,8,2,9,3,1,8,8,9,6,8,8,3,3,5,3,8,8,3,6,9,7,4,6,6,9,5,6,3,6,7,3,7,9,2,4,6,5,2,4,1,6,8,7,4,6,9,4,6,5,3,7,9,1,6,3,8,9,2,9,4,1,7,7,8,4,9,6,7,1,7,3,7,6,8,2,2,6,7,8,4,5,8,7,3,6,2,2,5,8,8,4,1,6,9,1,2,9,5,2,5,5,1,6,6,7,8,2,3,6,8,9,9,8,8,3,7,6,4,5,9,5,1,5,6,1,9,6,2,4,1,8,3,6,1,5,2,7,1,7,7,6,3,3,5,3,9,5,9,9,7,8,8,1,9,1,6,7,9,2,8,3,3,5,2,2,6,8,6,7,7,2,3,5,6,6,4,7,8,6,2,4,2,2,5,9,5,3,8,6,7,7,6,1,1,3,1,5,2,4,1,5,1,5,1,7,4,9,7,6,8,5,9,4,1,6,4,5,6,2,5,4,9,5,4,4,3,3,8,3,3,4,3,8,7,7,8,1,2,7,1,5,9,5,9,2,1,4,5,9,1,1,6,8,9,4,2,7,1,7,4,5,1,4,6,8,4,1,6,7,7,9,5,6,4,1,4,3,6,9,4,8,7,9,3,1,4,3,5,4,4,4,9,7,9,9,8,9,2,2,1,4,1,4,5,8,3,5,5,2,6,2,3,2,9,5,7,4,3,6,5,9,8,5,8,6,6,2,4,7,4,6,2,9,5,4,4,4,9,5,5,8,7,6,5,5,5,7,3,6,3,8,5,2,7,6,9,9,7,2,5,9,1,5,9,6,5,6,6,6,9,5,5,3,2,8,5,9,3,9,1,3,4,5,9,6,4,3,2,3,2,2,4,4,1,4,8,6,7,7,6,7,9,4,1,5,8,2,8,6,9,4,7,3,1,4,1,9,7,7,5,3,3,3,2,7,8,7,9,7,1,8,4,6,7,7,2,8,6,6,8,7,3,6,8,7,6,6,4,9,4,2,9,2,7,7,4,8,9,9,5,6,5,2,5,4,8,8,7,9,3,1,2,5,8,3,5,2,6,2,8,8,1,3,8,1,6,6,3,7,2,2,6,5,3,4,6,8,6,4,8,8,7,1,9,2,1,9,1,1,3,5,1,2,7,9,1,1,5,7,4,4,3,9,9,5,2,4,8,4,6,6,2,3,4,6,4,2,3,9,7,9,1,1,7,7,9,6,2,9,7,3,2,1,7,3,4,3,5,4,1,2,6,1,1,6,9,2,5,7,1,3,2,7,3,5,6,7,5,6,1,4,9,9,9,9,3,9,7,3,1,1,7,5,8,7,9,4,9,6,1,2,2,7,2,6,7,2,3,5,3,4,3,2,8,9,2,1,9,5,2,2,5,4,3,7,2,2,3,9,5,7,3,9,7,9,8,1,8,5,6,6,4,8,5,2,1,3,3,3,4,4,4,3,7,8,7,8,7,5,1,7,9,7,1,3,6,5,8,6,5,5,9,2,1,6,3,7,4,4,7,5,2,5,2,3,9,2,6,1,8,2,4,3,5,4,7,8,1,4,8,6,4,9,3,3,4,5,6,9,3,9,4,9,8,6,2,2,8,7,8,3,6,2,1,7,3,6,6,7,4,8,5,7,5,6,4,9,1,5,1,9,6,8,3,3,7,7,8,6,1,3,7,2,7,5,1,2,7,5,4,7,2,9,1,7,8,3,4,9,6,6,8,7,9,7,6,7,2,9,5,6,6,9,7,3,8,6,2,7,2,7,7,6,8,7,9,7,1,6,7,5,5
output =669

case =9
input =4,2,7,8,7,2,2,2,8,4,1,3,1,1,9,8,7,7,7,8,8,2,1,2,5,9,1,6,4,7,5,3,6,4,9,7,1,6,8,7,9,2,6,8,1,2,3,3,6,6,6,3,3,5,3,2,2,8,2,6,6,7,1,4,6,5,3,6,7,9,3,5,9,3,1,8,3,9,6,8,5,3,7,9,3,8,8,6,5,7,3,9,3,7,5,7,6,3,9,1,4,2,7,5,9,3,1,2,8,5,8,4,8,9,7,6,4,4,5,2,6,9,6,1,6,1,6,5,1,2,9,2,3,2,7,3,2,4,9,6,6,2,2,7,5,4,5,6,6,4,4,7,3,1,6,1,5,6,6,1,1,8,9,9,9,6,7,4,6,5,8,4,8,1,5,5,4,7,5,7,5,8,3,5,4,3,1,2,8,9,2,7,4,5,5,2,3,6,7,8,6,7,3,3,3,1,8,6,7,6,7,6,5,2,5,1,7,6,8,9,9,1,3,9,5,1,1,8,4,7,1,7,9,4,3,3,8,5,3,8,7,1,2,3,5,9,8,8,4,5,4,4,7,3,4,4,5,1,3,2,3,8,8,7,4,3,1,4,9,7,3,3,4,5,7,6,6,6,7,8,2,1,4,5,6,5,4,3,3,8,7,8,4,4,4,4,5,4,8,1,5,5,2,6,6,6,9,4,6,5,6,1,1,1,7,7,8,3,4,2,1,7,8,9,6,4,3,2,3,6,2,9,9,2,4,5,3,2,5,2,3,3,7,1,9,1,5,1,3,3,1,3,8,5,8,6,2,5,6,7,9,8,5,7,4,6,5,1,7,9,8,5,3,7,1,9,2,7,9,6,2,5,5,6,2,7,9,6,5,7,8,1,9,5,8,2,1,3,2,8,2,3,1,2,4,2,4,7,1,4,5,8,4,5,2,9,8,5,5,3,2,9,7,9,6,3,4,3,3,4,9,8,4,5,2,8,1,9,6,9,1,4,2,4,8,5,6,7,5,7,5,4,6,5,2,8,7,6,9,8,3,7,3,7,7,2,6,2,8,4,7,7,4,4,3,3,4,7,6,2,4,7,4,1,2,9,2,1,3,5,8,1,3,5,2,2,7,8,3,5,9,6,4,9,3,2,2,2,5,5,7,4,8,8,4,6,2,6,1,8,9,6,6,8,8,7,4,2,5,8,5,4,2,8,4,5,3,9,2,5,8,8,9,5,7,7,2,4,1,2,2,4,7,1,5,4,8,1,3,4,3,1,8,7,7,7,5,2,6,1,6,3,7,3,4,7,7,2,3,7,7,7,8,3,9,5,4,7,7,9,2,7,3,5,7,9,1,3,8,1,8,4,3,4,2,7,6,3,4,8,5,1,6,9,7,4,9,8,7,2,3,1,9,9,9,1,7,3,7,4,5,3,4,8,4,9,2,4,8,4,5,3,1,6,1,3,5,5,2,5,8,7,3,1,5,5,4,9,2,7,7,2,6,9,5,5,5,3,1,8,7,5,6,9,9,9,3,4,8,2,1,3,3,4,3,1,7,9,6,6,9,9,1,4,7,1,7,2,2,6,9,7,5,5,6,4,4,6,2,6,3,7,5,5,3,3,5,3,4,6,4,4,2,4,9,2,9,5,3,1,6,8,8,1,5,5,1,2,1,7,6,3,4,4,3,4,3,7,7,6,8,5,3,2,1,2,9,3,5,1,6,7,4,4,4,5,3,2,7,8,1,3,3,2,2,3,1,7,9,6,1,4,1,4,1,8,6,8,9,4,9,6,9,2,1,8,9,9,6,1,9,5,5,4,2,1,2,6,2,2,4,3,3,4,5,5,2,2,6,6,1,5,7,1,2,3,4,1,7,4,9,1,7,5,7,6,1,8,1,8,5,3,7,4,9,6,9,9,7,3,6,8,8,3,6,4,3,2,3,3,6,9,5,9,9,4,1,3,5,7,4,9,1,7,6,6,6,5,9,2,3,9,8,7,8,5,6,5,7,7,1,1,6,4,4,5,7,6,2,6,6,6,1,4,1,7,4,1,9,5,8,3,8,1,5,4,2,1,7,1,6,9,9,5,5,9,4,8,1,9,7,7,3,8,9,7,1,8,8,2,3,6,3,2,4,9,2,6,1,8,8,7,3,8,1,1,8,3,4,8,9,9,1,2,5,5,1,5,3,4,6,6,7,7,9,9,9,3,4,2,7,4,8,6,5,9,7,7,4,1,3,9,9,1,7,8,7,9,1,4,6,8,3,8,6,1,3,3,3,1,5,6,9,5,5,2,5,9,2,3,1,1,9,1,1,4,7,5,8,4,8,3,1,1,9,7,3,3,4,4,9,7,8,3,1,2,2,6,3,2,3,6,7,5,7,8,2,1,2,4,4,1,5,5,6,2,6,4,2,2,3,4,2,4,7,7,3,8,2,9,3,1,1,2,7,4,9,3,6,3,7,2,6,1,2,2,7,7,5,6,1,8,9,2,6,1,8,8,1,2,5,8,2,8,8,5,3,6,4,9,7,6,5,3,9,7,1,3,4,3,8,4,9,3,4,5,2,7,2,4,8,1,2,1,6,1,8,9,2,8,8,1,4,6,5,1,8,9,9,2,5,2,1,7,6,3,1,6,6,3,8,8,5,9,6,1,3,2,6,6,7,9,2,5,9,5,8,6,1,9,3,4,2,4,6,2,6,4,3,2,9,6,5,6,9,3,3,7,3,7,3,2,5,9,1,6,3,4,4,7,1,1,1,2,6,9,1,6,7,4,8,7,1,3,8,2,8,5,3,9,1,9,5,7,3,8,3,7,7,5,2,5,9,8,9,3,8,4,6,1,3,4,7,9,3,9,9,3,1,5,9,7,4,3,9,6,6,6,2,6,1,6,4,9,5,7,9,8,5,3,5,5,3,3,4,4,9,5,5,5,9,5,2,6,4,2,1,4,6,2,7,5,4,2,8,2,8,2,1,7,2,5,6,4,8,8,2,3,6,3,1,4,1,9,7,6,4,4,6,3,1,1,7,8,9,7,6,7,7,4,3,8,7,3,9,6,7,7,1,7,9,9,3,7,9,5,2,9,9,3,6,1,7,5,7,2,7,2,4,4,6,3,9,2,6,1,8,5,1,2,2,7,6,5,7,6,4,9,1,8,7,9,2,7,8,4,5,6,3,2,1,6,6,6,3,8,7,9,8,7,3,1,6,3,8,6,1,5,6,2,8,9,5,9,7,7,3,8,9,9,8,3,5,8,1,4,8,6,4,4,6,4,9,2,1,4,6,4,4,6,1,4,4,6,1,9,1,5,7,9,7,6,8,6,6,7,8,6,1,6,4,5,9,2,5,3,3,5,7,4,5,3,2,7,6,9,8,8,6,6,3,9,3,2,2,5,7,4,1,4,1,3,8,5,9,8,6,8,2,8,9,2,8,1,6,9,6,3,8,3,6,8,8,8,4,2,7,2,7,3,1,9,5,5,9,8,1,4,1,9,1,7,9,1,3,4,7,5,8,2,8,6,4,7,5,4,6,2,4,1,4,1,7,9,2,9,3,1,9,1,1,6,1,7,6,9,8,1,2,9,1,6,4,3,5,9,1,4,8,4,4,8,5,8,5,2,7,5,6,2,3,9,5,2,1,9,7,6,9,6,8,6,5,1,4,2,8,6,6,4,6,9,7,2,5,9,7,9,1,8,4,2,9,1,9,6,4,4,7,8,8,7,2,6,6,2,2,5,8,4,2,2,6,6,1,1,5,8,5,6,2,2,3,3,4,8,7,8,8,7,1,2,6,3,1,2,1,1,8,6,2,6,3,7,7,5,6,9,2,1,3,9,8,3,3,9,2,1,4,5,5,1,7,6,7,1,7,9,7,9,7,6,3,9,7,1,1,5,7,7,3,3,1,1,7,6,4,7,3,6,1,5,1,5,9,2,6,5,1,6,8,3,1,1,6,5,9,9,5,1,9,6,9,6,2,5,5,1,4,1,3,7,9,6,4,1,3,8,8,2,5,6,6,9,9,5,1,4,5,5,6,4,9,3,2,5,3,5,3,9,2,3,5,8,6,9,3,4,4,2,2,2,3,4,1,3,1,6,6,4,2,5,6,8,4,9,5,1,7,2,7,4,7,3,9,2,3,5,6,2,9,2,3,5,8,7,1,2,7,9,5,7,7,6,8,9,3,9,3,4,4,5,9,9,7,7,1,1,2,5,6,8,6,4,2,2,2,1,6,1,1,4,1,9,2,2,5,7,2,4,4,6,8,5,3,9,2,9,8,4,9,4,3,8,7,1,5,3,6,3,7,9,9,5,8,8,5,3,2,6,2,3,2,6,8,1,7,3,9,9,3,1,7,7,7,6,8,7,5,3,6,1,2,3,1,7,1,6,4,9,4,1,4,3,5,1,9,5,1,3,3,1,8,5,3,6,7,5,5,4,9,3,1,1,9,5,6,4,2,6,3,4,1,8,4,2,5,4,5,7,2,1,4,7,1,4,6,1,1,4,4,2,6,5,1,9,4,8,6,2,7,5,5,7,2,5,4,2,1,2,6,5,2,7,3,3,7,8,3,6,3,4,1,3,8,5,6,8,8,9,8,2,2,7,2,6,1,2,1,7,1,9,3,3,1,2,6,3,8,4,4,6,1,8,3,5,5,3,3,9,1,4,1,5,4,9,9,3,1,5,6,2,3,3,4,4,5,9,3,8,7,9,1,8,3,7,8,4,7,8,3,3,8,1,9,6,8,8,8,1,9,9,5,1,6,4,6,1,1,1,6,8,7,4,6,1,9,8,6,2,2,5,3,1,6,7,7,6,8,8,9,5,2,1,2,5,7,6,4,9,5,6,5,5,1,8,9,9,9,6,8,9,3,8,2,2,9,5,1,1,2,8,8,7,2,7,3,6,1,9,4,2,4,8,9,7,5,6,5,5,4,9,6,7,8,5,5,3,1,5,4,3,5,3,3,5,5,7,6,3,2,2,8,3,3,8,7,8,3,7,4,6,9,8,1,7,5,4,8,6,4,5,9,8,8,2,6,9,9,5,5,1,5,4,2,8,2,6,9,7,9,1,8,6,6,4,7,6,1,3,9,2,6,3,4,1,7,3,8,4,6,1,7,8,7,4,1,3,5,9,6,3,8,9,7,8,9,6,2,4,4,2,1,4,8,6,4,1,1,8,4,3,8,6,6,1,7,4,4,6,1,4,7,1,5,4,5,5,9,7,7,9,7,3,3,9,4,6,7,4,7,2,8,8,7,4,2,4,1,5,5,4,2,2,3,3,8,4,3,2,9,7,1,6,3,3,7,9,1,3,6,6,8,3,8,8,4,9,9,3,1,3,7,2,9,9,2,2,5,2,6,9,4,5,2,1,7,6,4,7,3,6,4,9,8,4,6,5,6,5,2,9,3,2,8,8,7,1,4,6,8,2,3,9,2,9,3,6,3,4,5,6,8,7,9,3,5,8,4,4,8,6,3,3,8,6,3,1,7,8,8,1,6,4,8,3,7,3,8,2,4,1,1,5,5,4,4,6,4,5,7,7,8,5,3,3,9,1,4,3,9,9,3,2,3,3,4,3,7,1,3,8,4,8,9,8,5,4,2,4,4,9,1,6,5,8,7,1,3,7,2,6,3,2,3,9,9,6,5,3,3,9,6,1,5,6,4,4,4,6,5,7,8,9,9,1,6,7,7,8,9,4,5,3,3,5,2,1,7,1,9,8,7,3,7,3,9,1,5,8,3,3,7,3,1,9,4,7,2,1,1,5,5,8,7,6,4,8,7,6,9,3,7,1,9,7,9,3,2,9,6,9,2,5,9,6,9,6,9,1,5,3,5,9,7,4,6,9,3,2,5,5,5,7,6,2,8,7,9,5,6,2,9,8,5,2,3,3,7,5,7,5,3,6,7,4,6,8,4,4,6,5,3,5,2,2,3,7,7,9,7,2,7,4,5,8,4,4,1,4,3,7,4,3,6,9,6,7,1,8,6,7,7,7,1,5,1,3,6,2,3,1,5,5,1,1,9,3,1,9,9,5,5,4,2,1,2,1,7,6,5,5,6,3,3,5,7,2,1,2,7,2,7,3,2,4,9,3,4,6,6,9,3,2,2,8,9,6,4,4,3,6,9,6,1,4,7,9,9,6,6,9,1,3,3,5,3,4,6,7,3,7,9,7,7,1,4,3,2,4,5,3,8,3,7,6,5,8,2,5,1,1,4,8,5,4,3,2,4,1,3,5,4,3,6,3,1,7,3,6,3,3,2,4,5,1,5,6,2,1,3,4,9,8,6,1,2,5,7,4,9,2,4,2,3,2,8,3,7,2,7,6,1,9,1,5,4,7,3,8,2,7,3,1,4,8,9,9,7,2,6,9,1,8,5,4,1,5,2,2,1,2,8,6,5,9,5,7,1,1,5,7,3,8,9,4,5,6,1,2,7,9,2,8,1,5,3,6,6,4,8,3,4,8,8,8,6,3,6,8,9,5,3,4,2,4,8,8,8,9,6,9,8,8,6,5,5,6,2,2,7,9,5,8,3,9,9,3,3,5,6,5,7,6,6,5,2,8,2,4,2,9,5,9,9,6,9,9,6,6,5,9,8,7,6,3,4,9,3,2,2,2,1,2,9,5,4,4,9,6,2,5,5,1,7,7,9,4,6,3,3,2,1,2,4,9,2,7,3,8,5,8,4,8,3,5,1,9,5,9,7,7,9,9,2,7,4,5,9,1,5,3,6,3,2,4,2,4,8,2,7,4,1,5,4,6,1,1,9,9,8,4,4,5,4,9,7,1,2,8,4,5,5,8,7,5,1,2,3,8,8,9,5,6,8,6,9,2,7,2,1,9,6,2,3,3,7,8,6,5,3,4,2,2,6,6,2,3,8,8,7,4,2,1,2,8,5,4,2,8,4,9,8,9,5,3,3,8,7,6,5,8,7,4,9,6,1,1,1,4,4,6,9,6,7,6,1,7,2,9,6,7,8,3,6,7,6,1,6,7,4,7,1,5,8,4,9,3,3,1,9,8,7,5,9,8,2,8,2,3,1,6,1,1,5,3,1,6,8,4,4,9,1,6,9,4,2,4,5,6,6,3,8,8,8,9,5,7,8,3,1,3,7,7,4,2,6,1,7,1,1,3,3,3,9,9,8,6,2,3,1,3,6,3,4,6,5,6,7,8,3,3,2,2,6,5,2,8,7,8,8,7,7,5,4,6,1,9,3,5,9,6,2,2,1,2,7,2,5,5,4,5,1,2,4,2,3,4,1,5,5,3,9,1,7,9,5,5,9,6,8,6,2,6,5,1,1,1,8,8,4,9,2,1,5,6,6,3,7,7,7,5,3,8,4,8,1,4,9,3,4,3,5,6,8,6,9,7,5,1,9,5,8,2,1,1,9,3,8,3,4,5,6,2,6,2,3,9,8,9,2,5,4,3,4,9,7,4,9,7,3,4,8,3,3,2,3,2,8,7,2,9,7,5,8,2,5,4,3,7,1,4,2,8,2,6,4,1,3,9,9,6,6,2,4,7,7,6,9,9,4,2,6,8,7,4,4,6,6,2,4,9,3,9,3,3,6,5,2,1,2,5,4,5,6,5,4,6,6,4,4,2,9,3,6,2,3,2,6,2,3,7,1,8,3,9,5,5,5,1,6,6,5,9,7,8,1,8,7,4,1,8,9,4,3,4,2,5,6,7,2,8,5,8,2,2,4,6,8,3,9,2,7,5,5,8,5,6,4,3,2,3,3,3,8,5,7,6,2,9,3,2,3,9,6,1,7,5,6,1,9,4,5,4,3,4,5,5,6,7,1,2,6,6,5,4,7,6,4,6,9,6,4,8,5,7,7,1,5,2,5,4,4,5,9,8,8,1,6,7,6,2,8,8,6,6,4,1,3,9,9,2,1,2,4,5,5,1,4,1,9,1,6,9,8,8,9,1,9,8,2,8,7,5,1,8,9,1,7,1,3,6,7,8,2,1,5,4,1,3,2,7,6,4,6,5,9,3,3,2,7,7,5,4,4,2,5,5,5,3,6,7,6,9,5,7,2,5,4,2,6,5,5,6,7,8,2,9,2,8,4,5,7,5,7,7,9,2,5,6,4,7,2,4,9,5,7,5,2,3,7,7,2,5,4,8,1,8,2,3,8,5,4,7,9,8,3,9,9,7,4,1,4,2,8,4,4,1,9,4,5,4,8,8,4,3,3,9,9,8,2,5,9,1,1,4,6,6,2,3,5,6,6,6,3,2,4,3,8,6,9,4,6,7,4,8,1,7,5,6,1,3,6,2,5,6,2,2,1,1,8,1,7,1,7,4,5,6,6,8,6,8,1,6,1,1,9,1,8,9,7,9,9,5,2,9,7,5,1,5,2,3,3,2,4,5,7,6,6,3,7,9,8,9,5,4,2,6,4,2,9,7,5,6,6,9,3,6,5,3,8,9,1,6,9,1,1,5,9,7,7,9,9,9,1,7,8,1,9,4,6,9,2,1,4,3,8,6,2,9,9,5,1,6,5,8,3,5,5,1,2,6,3,7,6,1,7,7,2,7,4,6,3,3,7,7,1,1,8,9,6,7,2,7,2,7,5,5,1,3,7,7,2,8,5,8,9,7,1,9,8,7,9,6,2,2,2,5,6,8,4,7,9,2,1,9,1,6,8,4,4,3,7,6,7,6,5,7,8,7,2,2,6,9,4,4,2,9,7,9,2,6,2,3,2,2,8,3,6,4,5,3,2,9,3,6,5,9,1,5,4,2,6,8,7,5,2,7,8,8,3,2,4,8,8,8,8,2,3,9,3,4,3,2,3,7,8,5,5,7,4,4,8,2,1,9,1,9,3,5,7,9,3,7,9,6,4,1,1,5,5,2,6,1,1,2,7,3,3,8,5,3,6,2,2,2,2,9,8,6,8,9,7,8,3,7,9,2,7,3,3,2,8,2,1,8,9,8,4,3,9,3,7,1,8,1,1,3,2,2,3,7,3,5,1,4,7,9,7,5,7,4,1,2,3,3,4,1,3,7,6,3,5,2,7,9,3,6,6,2,4,2,9,8,2,4,8,8,3,5,8,3,8,5,2,9,5,9,8,2,6,2,4,1,3,5,5,4,7,6,2,8,7,4,2,2,5,6,3,6,8,4,7,5,5,6,7,9,3,2,3,2,2,9,1,9,9,3,8,1,2,3,1,1,1,5,8,5,8,9,1,3,9,1,4,7,4,5,1,3,2,2,2,1,4,1,5,6,7,7,1,2,6,5,4,1,5,1,2,2,8,8,8,5,6,2,2,3,7,6,8,6,4,7,6,2,2,6,3,3,1,9,6,4,9,2,4,7,3,3,3,4,1,4,3,9,1,1,5,7,4,6,8,9,4,5,2,8,4,9,3,6,3,4,1,8,8,7,6,4,9,8,6,9,6,2,8,8,9,1,9,3,3,1,1,9,8,2,3,9,5,3,3,9,3,4,3,6,6,7,5,6,4,7,4,8,9,5,1,7,9,5,1,1,1,7,9,7,3,7,9,8,6,3,1,8,2,6,7,3,5,9,4,1,6,8,8,9,8,9,2,4,4,2,6,5,8,1,8,1,1,2,3,4,9,2,8,6,7,4,2,8,7,9,9,7,1,3,3,7,5,5,3,6,5,6,9,3,2,8,5,6,2,3,7,1,9,1,2,8,2,6,5,4,4,2,7,4,3,1,5,8,6,3,8,5,5,3,8,8,9,2,4,7,1,6,4,1,8,7,4,2,7,2,6,5,1,4,4,2,4,1,8,7,2,1,6,5,7,6,9,3,2,6,1,2,4,1,2,9,4,4,1,7,3,9,2,5,3,4,5,6,8,8,7,2,5,6,3,5,5,1,5,6,6,2,9,9,7,8,1,6,6,1,7,5,4,6,7,2,4,8,9,3,1,3,5,6,8,2,4,5,3,4,3,7,6,3,8,2,2,6,2,8,3,1,8,3,2,9,4,3,1,2,2,8,2,1,6,9,5,9,8,9,3,4,1,2,4,8,2,3,6,8,4,4,4,6,4,6,4,1,2,6,8,8,6,6,3,6,9,3,7,3,4,4,9,1,6,5,5,4,4,2,8,8,7,1,2,5,1,1,2,6,2,3,6,1,7,3,7,8,4,1,2,1,3,6,9,3,8,2,3,6,5,1,7,9,9,7,2,9,1,2,6,2,2,6,2,3,6,8,7,4,9,7,3,3,3,3,1,3,2,9,9,8,5,8,1,9,4,2,3,3,3,5,1,6,4,2,7,6,5,4,2,8,3,8,8,5,1,4,9,6,9,5,7,1,7,2,2,7,8,5,9,8,3,7,7,3,8,4,2,4,6,1,6,3,1,9,7,4,2,5,1,8,4,3,2,4,5,3,9,4,8,9,5,6,4,2,1,7,5,7,4,1,3,4,6,3,5,2,1,2,7,9,5,3,6,8,8,5,5,3,6,5,9,9,5,7,4,3,8,7,6,4,6,2,3,3,7,1,5,7,5,5,4,1,1,8,6,8,7,2,9,6,7,1,6,7,5,2,7,8,9,4,1,2,1,8,2,2,2,8,2,9,8,6,5,4,8,2,8,6,7,9,9,7,5,9,5,8,7,4,5,4,7,8,2,8,5,7,7,4,4,8,8,3,2,3,8,8,5,4,5,1,1,6,7,6,7,9,7,4,8,2,3,3,8,1,8,8,7,3,1,6,6,3,2,3,2,8,5,5,6,4,9,9,6,2,5,5,9,3,5,1,1,9,6,8,7,8,1,6,5,6,5,9,3,9,2,4,1,9,4,3,7,2,1,1,4,9,5,1,2,9,3,1,6,4,5,9,3,6,4,9,1,9,9,3,8,1,1,6,7,1,5,2,6,1,2,4,3,9,9,2,3,3,6,5,3,1,6,4,2,3,7,2,8,9,7,6,1,4,5,6,7,7,1,7,7,5,4,8,5,8,1,3,2,6,4,3,7,1,9,7,3,5,5,8,5,4,7,6,4,6,1,6,8,1,8,7,2,1,2,6,7,8,5,9,2,5,2,3,8,8,4,6,8,3,3,9,1,7,9,6,9,3,4,3,7,6,8,4,2,2,5,5,6,5,8,9,3,2,4,8,7,5,2,3,5,8,2,6,9,1,9,7,8,4,6,7,3,8,1,9,6,5,8,6,7,9,8,9,5,8,1,2,9,6,8,4,8,9,3,5,3,2,8,7,4,1,3,3,8,2,6,7,6,2,8,1,5,8,8,4,5,8,4,6
output =1669

case =10
input =32,50,42,21,21,44,44,43,5,36,31,25,12,27,37,21,1,9,19,23,50,6,50,4,42,19,21,23,26,41,32,42,1,18,42,49,10,46,24,50,14,32,6,45,3,42,18,15,45,10
output =-1

*/