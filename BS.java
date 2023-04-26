public class BS {
    public static void main(String args[]) {
        int n = 16;
        System.out.println(BinarySearch(n));
    }

    static int BinarySearch(int n) {
        int l = 1;
        int r = n;
        int a = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (m * m == n)
                return m;
            else if (m * m < n) {
                l = m + 1;
                a = m;
            } else {
                r = m - 1;
                a = m;
            }
        }
        return a;
    }
}