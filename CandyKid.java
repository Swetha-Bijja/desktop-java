
import java.util.*;

public class CandyKid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array = ");
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.print("Enter extra candy = ");
        int ec = sc.nextInt();
        System.out.println("Boolean result array = " + candy(n, a, ec));
    }

    static ArrayList<Boolean> candy(int n, int a[], int ec) {
        ArrayList<Boolean> al = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > max)
                max = a[i];
        }
        for (int i = 0; i < n; i++) {
            int m = a[i] + ec;
            if (m >= max)
                al.add(true);
            else
                al.add(false);
        }
        return al;
    }
}
