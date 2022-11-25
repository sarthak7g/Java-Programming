package array;

import java.util.Arrays;

/**
 * <h3>Level: Medium</h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/">Eating Favorite Candy On Favorite Day</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Calculate the prefix sum and think of two edge cases when you are not able to eat a candy</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class EatingFavoriteCandyOnFavoriteDay {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(canEat(new int[]{7,4,5,4,7}, new int[][]{{0,2,2},{4,2,4},{1,13,1000000000}, {4,6,3}, {3, 19, 4}, {3, 20, 4}})));
        System.out.println(Arrays.toString(canEat(new int[]{5,2,6,4,1}, new int[][]{{3,1,2},{4,10,3},{3,10,100},{4,100,30},{1,3,1}})));
    }

    public static boolean[] canEat(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int n=nums.length;
        long[] arr = new long[n+1];
        for(int i=0; i<n; i++) {
            arr[i+1] = arr[i] + nums[i];
        }

        int k=0;
        for(int[] q : queries) {
            if(arr[q[0]+1] > q[1] && arr[q[0]] < (long)(q[1]+1) * q[2]){
                ans[k] = true;
            }
            k++;
        }
        return ans;
    }
}
