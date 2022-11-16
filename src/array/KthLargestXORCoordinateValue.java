package array;

import java.util.PriorityQueue;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/">Find Kth Largest XOR Coordinate Value</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Prefix XOR and Min Heap</li>
 *      <li>Time complexity: O(n^2)</li>
 *      <li>Space complexity: O(n^2)</li>
 * </ul>
 */

public class KthLargestXORCoordinateValue {
    public static void main(String[] args) {
        System.out.println(kthLargestValue(new int[][]{{1, 5}, {2, 4}, {7, 8}}, 4));
        System.out.println(kthLargestValue(new int[][]{{1, 5}, {2, 4}, {7, 8}}, 2));
    }

    public static int kthLargestValue(int[][] matrix, int k) {
        int m=matrix.length, n=matrix[0].length, row_sum;
        int[][] arr = new int[m+1][n+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1; i<=m; i++) {
            row_sum = 0;
            for(int j=1; j<=n; j++) {
                row_sum ^= matrix[i-1][j-1];
                arr[i][j] = arr[i-1][j] ^ row_sum;
                if(pq.size() < k) {
                    pq.add(arr[i][j]);
                }else if(arr[i][j] > pq.peek()) {
                    pq.poll();
                    pq.add(arr[i][j]);
                }
            }
        }
        return pq.peek();
    }

}
