package array;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>Level: Easy </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/">Count Number of Pairs With Absolute Difference K</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: HashMap with frequency.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * </body>
 */

public class CountNumberOfPairsWithAbsoluteDifferenceK {

    public static void main(String[] args) {
        System.out.println(countKDifference(new int[] {1,2,2,1}, 1));
        System.out.println(countKDifference(new int[] {1, 3}, 3));
        System.out.println(countKDifference(new int[] {3,2,1,5,4}, 2));
    }

    public static int countKDifference(int[] nums, int k) {
        int ans=0, temp;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            temp = map.getOrDefault(num - k, 0);
            ans += temp;
            temp = map.getOrDefault(num + k, 0);
            ans += temp;
            map.put(num, map.get(num) - 1);
        }

        return ans;
    }
}
