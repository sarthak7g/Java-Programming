package array;

import java.util.HashMap;
import java.util.Map;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/contiguous-array/">Contiguous SubArray</a>
 * <br/>
 * Approach:
 * <ul>
 *     <li>Maintain a counter which will increase by 1 for every 1 & will decrease by 1 for every 0.</li>
 *     <li>Using prefix sum concept, we can say that whenever the value of count is same at different positions, that means we have a subarray of equal 0 and 1.</li>
 *     <li>Time complexity: O(n)</li>
 *     <li>Space complexity: O(n)</li>
 * </ul>
 */

public class ContiguousSubarrayWithEqual0And1 {

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[] {1,1,1,1}));
        System.out.println(findMaxLength(new int[] {0,0,0,0,0}));
        System.out.println(findMaxLength(new int[] {0,0,1,1,0,0,1,0,1,1,0,1,0}));
        System.out.println(findMaxLength(new int[] {0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,0,0,0,0,0,0}));
        System.out.println(findMaxLength(new int[] {0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,0,0,0}));
        System.out.println(findMaxLength(new int[] {0,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,1,1,1,1,0,0,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,1,1,1,0,1,1,0,0,0,1,1}));
    }

    public static int findMaxLength(int[] nums) {
        int count = 0, ans=0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                count -= 1;
            }else {
                count += 1;
            }

            if(map.containsKey(count)) {
                ans = Math.max(ans, i+1 - map.get(count));
            }else map.put(count, i+1);
        }

        return ans;
    }
}
