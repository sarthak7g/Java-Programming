package array;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <h4>LC PREMIUM</h4>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/widest-pair-of-indices-with-equal-range-sum/">Widest Pair of Indices With Equal Range Sum</a>
 * <br/>
 * <br/>
 * <b>Question:</b>
 * <ul>
 *     <li>You are given two 0-indexed binary arrays nums1 and nums2. Find the widest pair of indices (i, j) such that i <= j and nums1[i] + nums1[i+1] + ... + nums1[j] == nums2[i] + nums2[i+1] + ... + nums2[j].</li>
 *     <li>The widest pair of indices is the pair with the largest distance between i and j. The distance between a pair of indices is defined as j - i + 1.</li>
 *     <li>Return the distance of the widest pair of indices. If no pair of indices meets the conditions, return 0..</li>
 * </ul>
 *
 * <b>Example:</b>
 * <ul>
 *      <li><b>Input:</b> nums1 = [1,1,0,1], nums2 = [0,1,1,0]</li>
 *      <li><b>Output:</b> 3</li>
 * </ul>
 *
 * <b>Approach:</b>
 * <ul>
 *      <li>Calculate prefix sum of two arrays. Whenever the difference b/w the prefix sum is same at two indices, then we got new distance.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 *
 *
 */

public class WidestPairOfIndices_PrefixSumLC {
    public static void main(String[] args) {
        int[] num1 = {1, 0, 1, 1, 0, 0, 1, 1, 0, 0};
        int[] num2 = {0, 1, 1, 1, 0, 0, 1, 0, 0, 0};
        System.out.println(widestPairOfIndices(num1, num2));

        System.out.println(widestPairOfIndices(new int[]{0, 0, 1, 1, 1, 1, 0}, new int[]{0, 1, 0, 0, 1, 0, 1}));
        System.out.println(widestPairOfIndices(new int[]{0}, new int[]{0}));
        System.out.println(widestPairOfIndices(new int[]{1, 0, 0}, new int[]{1, 1, 0}));
    }

    public static int widestPairOfIndices(int[] nums1, int[] nums2) {
        int j = 0, n = nums1.length, s1 = 0, s2 = 0, dist = 0;

        Map<Integer, Integer> map = new HashMap<>();

        while (j < n) {
            s1 += nums1[j];
            s2 += nums2[j];

            if (s1 - s2 == 0) dist = Math.max(dist, j + 1);
            else if (map.containsKey(s1 - s2)) {
                dist = Math.max(dist, j - map.get(s1 - s2));
            } else map.put(s1 - s2, j);

            j++;
        }
        return dist;
    }
}
