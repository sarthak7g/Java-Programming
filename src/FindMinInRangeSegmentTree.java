import java.util.Scanner;

/**
 * <h3>Concept: Segment Tree</h3>
 * <body>
 * refer to: https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/tutorial/
 * <p>
 * Time Complexity:
 * <ul>
 * <li>Build Tree - O(n)</li>
 * <li>Update - O(log(n))</li>
 * <li>Query - O(log(n))</li>
 * </ul>
 * <p>
 *
 *
 * Sample input-
 * 5 5
 * 1 5 2 4 3
 * q 0 4
 * q 0 2
 * q 2 4
 * u 2 6
 * q 0 4
 * </p>
 *
 * </body>
 */
public class FindMinInRangeSegmentTree {

    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int q = s.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        // System.out.println(Arrays.toString(arr));

        int[] seg = new int[4 * n];
        for (int i = 0; i < 4 * n; i++) seg[i] = Integer.MAX_VALUE;
        buildTree(seg, arr, 0, 0, n - 1);
        // System.out.println(Arrays.toString(seg));

        // queries
        for (int i = 0; i < q; i++) {
            String in = s.next();
            if (in.equals("u")) {
                int pos = s.nextInt();
                int val = s.nextInt();
                update(seg, 0, n - 1, pos, val, 0);
                // System.out.println(Arrays.toString(seg));
            } else {
                int l = s.nextInt();
                int r = s.nextInt();
                System.out.println(query(seg, 0, n - 1, l, r, 0));
            }

        }

    }

    private static void buildTree(int[] seg, int arr[], int ind, int start, int end) {
        if (start == end) {
            seg[ind] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        buildTree(seg, arr, 2 * ind + 1, start, mid);
        buildTree(seg, arr, 2 * ind + 2, mid + 1, end);

        seg[ind] = Math.min(seg[2 * ind + 1], seg[2 * ind + 2]);


    }

    private static void update(int[] seg, int start, int end, int pos, int val, int ind) {
        if (start == end) {
            seg[ind] = val;
            return;
        }

        int mid = (start + end) / 2;
        if (pos <= mid) {
            update(seg, start, mid, pos, val, 2 * ind + 1);
        } else {
            update(seg, mid + 1, end, pos, val, 2 * ind + 2);
        }
        seg[ind] = Math.min(seg[2 * ind + 1], seg[2 * ind + 2]);

    }

    private static int query(int[] seg, int start, int end, int l, int r, int ind) {

        // 1) completely inside (l,r)
        if (start >= l && end <= r) {
            return seg[ind];
        }
        // 2) does not overlap
        if (start > r || l > end) {
            return Integer.MAX_VALUE;
        }
        // 3) overlap partially
        int mid = (start + end) / 2;
        int leftAns = query(seg, start, mid, l, r, 2 * ind + 1);
        int rightAns = query(seg, mid + 1, end, l, r, 2 * ind + 2);

        return Math.min(leftAns, rightAns);
    }
}
