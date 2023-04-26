import java.util.*;

public class Height {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size = ");
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println("Maximum Area = " + maxArea(a));
    }

    static int maxArea(int[] a) {
        int n = a.length;
        int l = 0, r = n - 1, ma = 0;

        while (l < r) {
            int ar = Math.min(a[l], a[r]) * (r - l);
            ma = Math.max(ma, ar);

            if (a[l] < a[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ma;
    }
}
