import java.util.*;

public class ClosestSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.print("Enter target = ");
        int t = sc.nextInt();
        System.out.println("Closest sum of any 3 integers = " + closestsum(a, n, t));
    }

    static int closestsum(int a[], int n, int t) {
        Arrays.sort(a);
        int cs = a[0] + a[1] + a[2];
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = a[i] + a[l] + a[r];
                if (Math.abs(sum - t) < Math.abs(cs - t)) {
                    cs = sum;
                }
                if (sum < t) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return cs;
    }
}
