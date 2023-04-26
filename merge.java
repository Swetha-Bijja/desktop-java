import java.util.*;

public class merge {
    public static void main(String args[]) {
        int[] n = { 2, 7, 11, 15 };
        int t = 9;
        ArrayList<Integer> al = new ArrayList<>();
        int i = 0, j = n.length - 1;
        while (i < j) {
            if (n[i] + n[j] == t) {
                al.add(i);
                al.add(j);
            } else if (n[i] + n[j] > t) {
                j--;
            } else
                i++;
        }
        System.out.print(al);
    }
}
