package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/random-pick-with-weight/">Random Pick with Weight</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Create a prefix sum array. Use random function to find an index from 1 to last value of prefix array.</li>
 *      <li>Whatever value is picked by random function, find the next closest index having that value.</li>
 *      <li>Time complexity: O(log n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class RandomPickWithWeight {
    int[] arr;
    public RandomPickWithWeight(int[] w) {
        arr = new int[w.length];
        int sum = 0, i=0;
        for(int num : w) {
            sum += num;
            arr[i++] = sum;
        }
    }
    public int pickIndex() {
        int index = (int)(Math.random() * arr[arr.length-1]) + 1;
        return findBinarySearch(index);
    }

    private int findBinarySearch(int x) {
        int start = 0, end = arr.length-1, mid;

        while(start <= end) {
            mid = (start + end)/2;

            if(arr[mid] == x) {
                return mid;
            }
            else if(x > arr[mid]) {
                start = mid+1;
            }else end = mid-1;
        }

        return start;
    }

    public static void main(String[] args) {
        RandomPickWithWeight obj = new RandomPickWithWeight(new int[] {1, 2, 4, 6, 2, 4, 3});
        for (int i = 0; i < 10; i++) {
            System.out.println(obj.pickIndex());
        }
    }
}
