package array;

/**
 * <h3>Level: Medium</h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/largest-sum-of-averages/">Largest Sum of Averages</a>
 * <br/>
 * <br/>
 * <b>Approach:</b>
 * <ul>
 *      <li>Hint: Recursive Dp</li>
 *      <li>Time complexity: O(k * n^2)</li>
 *      <li>Space complexity: O(n^2)</li>
 * </ul>
 */

public class LargestSumOfAverages {
    public static void main(String[] args) {
        System.out.println(largestSumOfAverages(new int[] {4,1,7,5,6,2,3}, 4));
        System.out.println(largestSumOfAverages(new int[] {4,1,7,5,6,2,3}, 7));
        System.out.println(largestSumOfAverages(new int[] {4,1,7,5,6,2,3,5,2,4,1,1,9}, 8));
    }

    static double[][] dp = new double[101][101];
    public static double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for(int i=0; i<n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        if(k == n) {
            return sum[n];
        }
        return find(sum, 0, k, n);
    }

    static double find(int[] sum, int st, int k, int n) {
        if(k <= 0) return 0;
        if(dp[st][k] != 0) return dp[st][k];

        double ans=0, temp=0;
        if(k == 1) {
            ans = (double)(sum[n]-sum[st])/(n-st);
        }else {
            for(int i=st; i<=n-k; i++) {
                temp = (double)(sum[i+1]-sum[st])/(i-st+1);
                temp += find(sum, i+1, k-1, n);
                ans = Math.max(ans, temp);
            }
        }
        dp[st][k] = ans;
        return ans;
    }
}
