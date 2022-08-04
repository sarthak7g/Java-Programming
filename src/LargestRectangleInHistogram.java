import java.util.Arrays;

/**
 *
 * <h3>Level: Hard </h3>
 * <body>
 * refer to: https://leetcode.com/problems/largest-rectangle-in-histogram/
 * <br/>
 * Approach:
 *      Build segment tree that will store the indexes of min element
 *      Query segment tree in O(log(n))
 *
 * <br/>
 * Time complexity: O(nlog(n))
 * </body>
 *
 */

class LargestAreaInHistogram {
    public static void main(String[] args) {
//        int[] arr = {2, 1, 5, 6, 2, 3};
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(largestRectangleArea(arr));
    }

    public static int largestRectangleArea(int[] arr) {
        int n = arr.length;
        int seg[] = new int[4 * n];

        for (int i = 0; i < 4 * n; i++) {
            seg[i] = Integer.MAX_VALUE;
        }

        buildTree(seg, arr, 0, n - 1, 0);
        System.out.println(Arrays.toString(seg));

        return findMaxArea(seg, arr, n, 0, n - 1);
    }

    static void buildTree(int[] seg, int[] arr, int start, int end, int idx) {
        // System.out.println(start + " " + end);
        if (start == end) {
            seg[idx] = start;
            return;
        }
        int mid = (start + end) / 2;
        buildTree(seg, arr, start, mid, 2 * idx + 1);
        buildTree(seg, arr, mid + 1, end, 2 * idx + 2);

        if (arr[seg[2 * idx + 1]] <= arr[seg[2 * idx + 2]]) {
            seg[idx] = seg[2 * idx + 1];
        } else seg[idx] = seg[2 * idx + 2];
    }

    static int findMaxArea(int[] seg, int[] arr, int n, int start, int end) {
        if (start > end) {
            return Integer.MIN_VALUE;
        }

        if (start == end) {
            return arr[start];
        }

        // find Min for range
        int min = findIndexMin(seg, arr, 0, n - 1, start, end, 0);
        int max = arr[min] * (end - start + 1);


        int leftMax = findMaxArea(seg, arr, n, start, min - 1);
        int rightMax = findMaxArea(seg, arr, n, min + 1, end);

        return findMax(leftMax, rightMax, max);

    }

    static int findIndexMin(int[] seg, int[] arr, int start, int end, int l, int r, int idx) {
        // 1) does not intersect
        if (start > r || l > end) {
            return -1;
        }

        if (start == end) {
            return start;
        }

        // 2) overlap completely
        if (start >= l && r >= end) {
            return seg[idx];
        }



        // 3) partially overlap
        int mid = (start + end) / 2;
        System.out.println("l and r: " + l + r + " start & end: " + start + " " + end);
        int leftAns = findIndexMin(seg, arr, start, mid, l, r, 2 * idx + 1);
        int rightAns = findIndexMin(seg, arr, mid + 1, end, l, r, 2 * idx + 2);

        if (leftAns == -1) return rightAns;
        if (rightAns == -1) return leftAns;

        if (arr[leftAns] <= arr[rightAns]) {
            return leftAns;
        } else return rightAns;

    }

    static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }


}