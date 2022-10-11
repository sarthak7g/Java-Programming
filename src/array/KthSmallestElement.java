package array;

import java.util.PriorityQueue;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1">Kth Smallest element</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Hint: Use max heap</li>
 *      <li>Time complexity: O(N * log k)</li>
 *      <li>Space complexity: O(k)</li>
 * </ul>
 *
 */

public class KthSmallestElement {

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        System.out.println(kthSmallest(arr, 0, arr.length-1, 3));
        System.out.println(kthSmallest(arr, 0, arr.length-1, 4));
    }

    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        int i=0;
        while(i<k) {
            pq.add(arr[i++]);
        }

        i=l+k;
        while(i<=r) {
            if(arr[i] < pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
            i++;
        }

        return pq.poll();
    }
}
