package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/k-largest-elements4206/1">K largest elements</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Use min heap</li>
 *      <li>Time complexity: O(k * log k)</li>
 *      <li>Space complexity: O(k)</li>
 * </ul>
 *
 */

public class KLargestElements {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(kLargest(new int[]{12, 5, 787, 1, 23}, 3)));
        System.out.println(Arrays.toString(kLargest(new int[]{12, 5, 787, 1, 23}, 5)));
        System.out.println(Arrays.toString(kLargest(new int[]{1, 23, 12, 9, 30, 2, 50}, 3)));
    }

    static int[] kLargest(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i=0;
        while(i<k) {
            pq.add(arr[i++]);
        }

        while(i<n) {
            if(pq.peek() < arr[i]) {
                pq.poll();
                pq.add(arr[i]);
            }
            i++;
        }

        int[] ans = new int[k];
        for(int j=k-1; j>=0; j--) {
            ans[j] = pq.poll();
        }
        return ans;
    }
}
