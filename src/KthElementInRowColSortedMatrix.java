import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * <p>
 * <h4>Approach 1:</h4>
 * <ul>
 *      <li>Use max heap of size k, for each iteration</li>
 *      <li>if an element less than the max, replace it with the max element</li>
 * </ul>
 * Time complexity: O(n*m) <br/>
 * Space complexity: O(k)
 * </p>
 * <p>
 * <h4>Approach 2: </h4>
 * <ul>
 *      <li>Use min heap of size n, store all n elements of 1st row with their row, col, and value.</li>
 *      <li>Then, for each iteration from 0 to k-1</li>
 *      <li>remove min element from heap and replace it with the next element in the same column</li>
 * </ul>
 * Time complexity: O(K*Log(n)) <br/>
 * Space complexity: O(n)
 * </p>
 *
 *
 *
 * </body>
 */

public class KthElementInRowColSortedMatrix {
    public static void main(String[] args) {
        int matrix[][] = {{10, 20, 30, 40}, {15, 25, 35, 45}, {24, 29, 37, 48}, {32, 33, 39, 50}};
        System.out.println(kthSmallest(matrix, matrix.length, 7));
        System.out.println(kthSmallest2(matrix, matrix.length, 7));
    }

    public static int kthSmallest(int[][] arr, int n, int k) {
        // approach 1- T(n) = O(m*n), S(n) = O(k)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pq.size() < k) {
                    pq.add(arr[i][j]);
                } else if (pq.peek() > arr[i][j]) {
                    pq.poll();
                    pq.add(arr[i][j]);
                } else {
                    break;
                }
            }
        }

        return pq.peek();
    }

    public static int kthSmallest2(int[][] arr, int n, int k) {
        // approach 2- T(n) = O(K*Log(n)), S(n) = O(n)
        // If k is significantly less than n, then the heap size of k would be taken
        PriorityQueue<IndexPair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (int i = 0; i < n; i++) {
            pq.add(new IndexPair(0, i, arr[0][i]));
        }

        int val;
        IndexPair indexPair = new IndexPair();
        for (int i = 0; i < k; i++) {
            indexPair = pq.poll();
            val = indexPair.row == n - 1 ? Integer.MAX_VALUE : arr[indexPair.row + 1][indexPair.col];
            pq.add(new IndexPair(indexPair.row + 1, indexPair.col, val));
        }
        return indexPair.val;
    }

    static class IndexPair {
        int row;
        int col;
        int val;

        IndexPair() {

        }

        IndexPair(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        public String toString() {
            return "" + this.val;
        }
    }
}
