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
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Select a random element between l and r as pivot element for the partition algorithm in quick sort.</li>
 *      <li>Based on the index of pivot element after partition algorithm is applied, we can increment l or decrement r.</li>
 *      <li>Time complexity: O(N), according to MIT. Refer to: <a href="https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/">soltuion</a></li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 */

public class KthSmallestElement {

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        System.out.println(kthSmallest(arr, 0, arr.length-1, 3));
        System.out.println(kthSmallest(arr, 0, arr.length-1, 4));

        System.out.println(kthSmallest2(arr, 0, arr.length-1, 3));
        System.out.println(kthSmallest2(arr, 0, arr.length-1, 4));
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


    public static int kthSmallest2(int[] arr, int l, int r, int k)
    {
        // select Random
        int rand = (int)(Math.random() * (r-l+1));
        int pivot = l+rand;

        // swap
        swap(arr, pivot, r);

        // partition
        int index = partition(arr, l, r);
        // System.out.println(index);

        if(index == k-1) return arr[index];

        if(index > k-1) return kthSmallest2(arr, l, index-1, k);

        return kthSmallest2(arr, index+1, r, k);

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int l, int r) {
        int i=l-1, j=l;
        while(j<=r) {
            if(arr[j] <= arr[r]) {
                swap(arr, i+1, j);
                i++;
            }
            j++;
        }
        return i;
    }
}
