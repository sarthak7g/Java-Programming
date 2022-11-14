package array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.coMaximize sum after K negationsm/problems/ways-to-split-array-into-three-subarrays/">Ways to Split Array Into Three Subarrays</a>
 * <br/>
 * <br/>
 * <b>Approach I:</b>
 * <ul>
 *      <li>We will find the start_index and end_index for the middle array using binary search.</li>
 *      <li>The solution is correct for all test cases.</li>
 *      <li>Time complexity: O(n * log n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * <b><a href="https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/discuss/999257/C%2B%2BJavaPython-O(n)-with-picture">Approach II:</a></b>
 * <ul>
 *      <li>Instead of using binary search we will use three pointers which can only move forward.</li>
 *      <li>Pointer i represents the last index of left sub-array, pointer j and k will represent the min and max index in mid sub-array respectively.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class WaysToSplitArrayIntoThreeSubarrays {
    public static void main(String[] args) {
        System.out.println(waysToSplit(new int[]{4, 2, 3, 0, 3, 5, 3, 12}));
        System.out.println(waysToSplit(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        System.out.println(waysToSplit(new int[]{7, 0, 5}));
        System.out.println(waysToSplit(new int[]{1, 2, 2, 2, 5, 0}));
        System.out.println(waysToSplit(new int[]{8892, 2631, 7212, 1188, 6580, 1690, 5950, 7425, 8787, 4361, 9849, 4063, 9496, 9140, 9986, 1058, 2734, 6961, 8855, 2567, 7683, 4770, 40, 850, 72, 2285, 9328, 6794, 8632, 9163, 3928, 6962, 6545, 6920, 926, 8885, 1570, 4454, 6876, 7447, 8264, 3123, 2980, 7276, 470, 8736, 3153, 3924, 3129, 7136, 1739, 1354, 661, 1309, 6231, 9890, 58, 4623, 3555, 3100, 3437}));

        System.out.println();

        System.out.println(waysToSplit2(new int[]{4, 2, 3, 0, 3, 5, 3, 12}));
        System.out.println(waysToSplit2(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
        System.out.println(waysToSplit2(new int[]{7, 0, 5}));
        System.out.println(waysToSplit2(new int[]{1, 2, 2, 2, 5, 0}));
        System.out.println(waysToSplit2(new int[]{8892, 2631, 7212, 1188, 6580, 1690, 5950, 7425, 8787, 4361, 9849, 4063, 9496, 9140, 9986, 1058, 2734, 6961, 8855, 2567, 7683, 4770, 40, 850, 72, 2285, 9328, 6794, 8632, 9163, 3928, 6962, 6545, 6920, 926, 8885, 1570, 4454, 6876, 7447, 8264, 3123, 2980, 7276, 470, 8736, 3153, 3924, 3129, 7136, 1739, 1354, 661, 1309, 6231, 9890, 58, 4623, 3555, 3100, 3437}));
    }

    public static int waysToSplit(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Integer st_sum, end_sum;
        int sum = 0, ls = 0, si, ei, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            map2.put(sum, i);
        }
        // System.out.println(map);
        for (int i = 0; i < nums.length - 2; i++) {
            ls += nums[i];

            st_sum = map.ceilingKey(2 * ls);
            if (st_sum == null) {
                break;
            } else si = map.get(st_sum);
            si = Math.max(i + 1, si);

            end_sum = (sum + ls) / 2;
            end_sum = map.floorKey(end_sum);
            if (end_sum == null) {
                ei = si;
            } else {
                ei = map2.get(end_sum) + 1;
            }

            ei = Math.max(ei, si);
            // System.out.println(si + " " + k);

            ans = (ans + ei - si) % 1000000007;

        }

        return ans;
    }

    public static int waysToSplit2(int[] nums) {
        int sum = 0, n = nums.length, j = 0, k = 0, ans = 0;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            arr[i] = sum;
        }

        for (int i = 0; i < n - 2; i++) {
            while (j < n - 1 && arr[j] < 2 * arr[i]) j++;
            j = Math.max(i + 1, j);

            while (k < n - 1 && arr[n - 1] - arr[k] >= arr[k] - arr[i]) k++;
            k = Math.max(j, k);
            ans = (ans + k - j) % 1000000007;

        }

        return ans;
    }
}
