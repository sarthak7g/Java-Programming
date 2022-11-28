package array;

/**
 * <h3>Level: Easy</h3>
 * <body>
 * refer to: <a href="https://leetcode.com/problems/sum-of-all-odd-length-subarrays/">Sum of All Odd Length Sub Arrays</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Hint: Calculate the prefix sum and at each index subtract the sum at index-3, index-5,... and so on to calculate the final ans.</li>
 *      <li>Time complexity: O(n^2)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Find a mathematical equation. Iterate from i=1 to length and update variable ans.</li>
 *      <li>If i is even, ans = sum[i] * (i+1)/2 -  [sum[i-1] + sum[i-3] +...+sum[1]].</li>
 *      <li>Else, ans = sum[i] * (i+1)/2 -  [sum[i-1] + sum[i-3] +...+sum[0]].</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(n)</li>
 * </ul>
 */

public class SumOfAllOddLengthSubArrays {
    public static void main(String[] args) {
        System.out.println(sumOddLengthSubarrays(new int[] {1,4,2,5,3}));
        System.out.println(sumOddLengthSubarrays(new int[] {1,4,2,5,3,1,3}));
        System.out.println();
        System.out.println(sumOddLengthSubarrays2(new int[] {1,4,2,5,3}));
        System.out.println(sumOddLengthSubarrays2(new int[] {1,4,2,5,3,1,3}));
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int l = arr.length;
        int[] sum = new int[l+1];
        for(int i=0; i<l; i++) {
            sum[i+1] = sum[i] + arr[i];
        }
        int ans = sum[l], j;
        for(int i=3; i<=l; i++) {
            j=i-3;
            while(j>=0) {
                ans = ans + sum[i]-sum[j];
                j-=2;
            }
        }
        return ans;
    }

    public static int sumOddLengthSubarrays2(int[] arr) {
        int n = arr.length, odd_sum=0, even_sum=0, ans=0, to_subtract=0;
        int[] sum = new int[n+1];
        for(int i=0; i<n; i++) {
            sum[i+1] = sum[i] + arr[i];
        }

        for(int i=1; i<=n; i++) {
            ans = ans + sum[i]*((i+1)/2);
            if(i % 2 == 0) {
                odd_sum += sum[i-1];
                to_subtract += odd_sum;
            }else {
                even_sum += sum[i-1];
                to_subtract += even_sum;
            }
        }

        ans -= to_subtract;
        return ans;
    }
}
