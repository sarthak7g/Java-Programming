package array;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/">Maximum Points You Can Obtain from Cards</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Find forward and backward sum.</li>
 *      <li>For each x in [0, k], find left sum i.e., sum in [0, x] and right sum i.e., sum in [n-(k-x),...n] and update the answer accordingly.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class MaximumPointsObtainFromCards {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1,4,3,2,3,4,5,1,6}, 3));
        System.out.println(maxScore(new int[]{4,3,2,3,4,5,1,6}, 3));
        System.out.println(maxScore(new int[]{1,4,3,2,3,4,5,1,6}, 8));
    }

    public static int maxScore(int[] arr, int k) {
        int[] back = new int[arr.length];

        int sum=0, temp, ans=0;
        for(int i=arr.length-1; i>=0; i--) {
            sum += arr[i];
            back[i] = sum;
        }

        sum=0;
        for(int i=0; i<k; i++) {
            temp = k-i;
            ans = Math.max(ans, sum + back[arr.length-temp]);
            sum += arr[i];
        }
        ans = Math.max(ans, sum);

        return ans;

    }
}
