import java.util.*;

public class DandC {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = 4;
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        QuickSort(a, 0, n - 1);
        System.out.println(1);
    }

    static void QuickSort(int a[], int l, int r) {
        if (l < r) {
            int pi = partition(a, l, r);
            QuickSort(a, l, pi - 1);
            QuickSort(a, pi + 1, r);
        }
    }

    static int partition(int a[], int l, int r) {
        int pi = a[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {
            if (a[j] < pi) {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[i + 1];
        a[i + 1] = a[r];
        a[r] = t;
        return i + 1;
    }

}
