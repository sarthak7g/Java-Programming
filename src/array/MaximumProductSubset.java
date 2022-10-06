package array;

import java.util.Scanner;

/**
 * <h3>Level: Medium </h3>
 * <body>
 * refer to: <a href="https://practice.geeksforgeeks.org/problems/maximum-product-subset-of-an-array/1">Maximum product subset of an array</a>
 * <br/>
 * <br/>
 * <b>Approach 1:</b>
 * <ul>
 *      <li>Find the whole product excluding zeroes and maintain min -ve value.</li>
 *      <li>If the overall product is negative then, divide by the min -ve number you're holding.</li>
 *      <li>If the overall product is 1, then check if we had any 1s in the array.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 * <b>Approach 2:</b>
 * <ul>
 *      <li>Find the positive product and negative product while maintaining the min -ve value. Now, we can easily find the maximum product without zeroes.</li>
 *      <li>For the corner cases we can maintain number of negatives and number of zeroes.</li>
 *      <li>If there are all 0s or 1 -ve and n-1 0s then, answer would be 0.</li>
 *      <li>Time complexity: O(n)</li>
 *      <li>Space complexity: O(1)</li>
 * </ul>
 */

public class MaximumProductSubset {
    public static int[] input() {
        // 69
        // 7 -2 7 -1 2 -3 -10 -2 -9 6 -5 -10 9 4 -5 6 0 2 -10 -5 -6 1 -6 6 -3 7 7 -9 -10 -4 -9 4 9 10 3 -7 -6 6 3 7 -3 -2 -10 -2 10 -3 -9 0 7 -1 -3 5 -5 -4 -3 2 3 2 -7 -8 9 10 10 2 4 2 -8 2 -3
        // copy-paste for this input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = input();
        System.out.println(findMaxProduct(arr));
        System.out.println(findMaxProduct2(arr));
        System.out.println(findMaxProduct(new int[] {0,0,0,0}));
        System.out.println(findMaxProduct2(new int[] {0,0,0,0}));
    }


    public static int findMaxProduct(int[] arr) {
        if (arr.length == 1) return arr[0];

        int maxNeg = -10;
        long prod = 1;
        boolean checkOne = false;
        for (int j : arr) {
            if (j == 0) continue;

//            System.out.println(j + " " + prod + " " + maxNeg);

            if (j == 1) checkOne = true;

            prod *= j;

            if (j < 0 && maxNeg < j) maxNeg = j;

        }

//        System.out.println(prod + " " + maxNeg);

        if (prod < 0) prod /= maxNeg;
        if (prod == 1 && !checkOne) return 0;

        long ans = (long) (Math.pow(10, 9) + 7);
        return (int) (prod % ans);
    }

    public static int findMaxProduct2(int[] arr) {
        int n = arr.length;
        if(n==1) return arr[0];

        int maxNeg=-10, countn=0, countz=0;
        long pprod=1, nprod=1;
        for (int j : arr) {
            if (j == 0) {
                countz++;
                continue;
            }

            if (j < 0) {
                countn++;
                if (j > maxNeg) maxNeg = j;
                nprod *= j;
            } else pprod *= j;

        }

        if(countz == n || (countz == n-1 && countn == 1)) return 0;

        long temp = (long) (Math.pow(10, 9) + 7);
        // System.out.println(prod + " " + maxNeg);

        if(nprod < 0) nprod /= maxNeg;
        pprod *= nprod;

        return (int) (pprod % temp);
    }
}
