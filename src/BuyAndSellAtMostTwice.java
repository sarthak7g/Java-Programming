
/**
 *
 * Level: Medium
 * refer to: https://practice.geeksforgeeks.org/problems/buy-and-sell-a-share-at-most-twice/1/
 *
 * Approach - Idea is to find the i such that for i belongs to [0,i] [i+1, n], we get the maximum profit
 *      1) Traverse from right to left and find out the maxProfit that you can get at each index and
 *      store it in profit array. For that a maxVal from the right needs to be stored.
 *      2) Now traverse from left to right either create a new array or update profit array and
 *      store the max profit you get at each step.
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 */


public class BuyAndSellAtMostTwice {

    public static void main(String[] args) {
        int ans = maxProfit(8, new int[]{2, 10, 8, 18, 7, 91, 33, 250});
        System.out.println(ans);
    }

    public static int maxProfit(int n, int[] arr) {

        if(n==1) return 1;
        int [] profit = new int[n];
        int maxVal = arr[n-1];

        for(int i=n-2; i>=0; i--) {
            maxVal = Math.max(maxVal, arr[i]);
            profit[i] = Math.max(profit[i+1], maxVal-arr[i]);
        }
        // System.out.println(Arrays.toString(profit));

        int minVal = arr[0];
        for(int i=1; i<n-1; i++) {
            minVal = Math.min(minVal, arr[i]);
            profit[i] = Math.max(profit[i-1], arr[i]-minVal + profit[i+1]);
        }
        // System.out.println(Arrays.toString(profit));

        return profit[n-2];


    }
}
