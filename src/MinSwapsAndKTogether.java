

/**
 *
 * Level: Medium
 * refer to: https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1
 *
 * Approach-
 *      1) find the window size
 *      2) then, for each window find the optimum size
 *
 * Time complexity: O(n)
 *
 */

public class MinSwapsAndKTogether {
    public static void main(String[] args) {
        int arr[] = {4, 11, 6, 5, 11, 20, 19, 14, 14, 2, 9, 20, 11, 11, 15, 1, 7, 12, 19, 9};
        System.out.println(minSwap(arr, arr.length, 14));
    }
    public static int minSwap (int arr[], int n, int k) {
        // Get the window size
        int window = 0;
        for(int i=0; i<n; i++) {
            if(arr[i]<=k) {
                window+=1;
            }
        }
        int count = 0, maxElems=0, j=0;

        // Get the maxElems possible in a window
        for(int i=0; i<=n-window; i++) {
            if(i==0) {
                j=0;
                while(j<window) {
                    if(arr[j]<=k) {
                        count += 1;
                    }
                    j++;
                }
                maxElems = Math.max(count, maxElems);
            }else {
                j=i+window-1;
                if(arr[i-1]<=k) {
                    count -= 1;
                }
                if(arr[j]<=k) {
                    count += 1;
                }
                maxElems = Math.max(count, maxElems);
            }
             System.out.println("maxElems: " + maxElems + ", count: " + count);
        }

        // System.out.println("maxElems: " + maxElems);
        return window-maxElems;

    }

}
