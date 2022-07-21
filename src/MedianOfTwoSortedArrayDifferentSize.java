/**
 *
 * Level: Hard
 * refer to: https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * Approach:
 *      Get i1 which is mid of arr1 and i2 using formula-> i2 = (n1+n2+1)/2 -i1
 *      Then, we divide the elements in two parts and goal is to achieve smaller elements on the left part and bigger on the right
 *      part1 will have elements from [0...i1-1] & [0...i2-1]
 *      part2 will have elements from [i1...n1] & [i2...n2]
 *      compare maximum from left part and minimum from right part
 *
 * Time complexity: O(log(n))
 *
 * PS: The mentioned solution can be more simply written
 *
 */

public class MedianOfTwoSortedArrayDifferentSize {

    public static void main(String[] args) {
        int arr1[] = {1,1,1,1,1,1,1,1,1,1,4,4};
        int arr2[] = {1,3,4,4,4,4,4,4,4,4,4};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if(n1 == 0 && n2 == 0) {
            return 0;
        }
        if(n1 == n2 && n1 == 1) {
            return (double)(nums1[0] + nums2[0])/2;
        }
        if(n1 <= n2)
            return findMedian(nums1, nums2, n1, n2);
        else return findMedian(nums2, nums1, n2, n1);
    }

    private static double findMedian(int[] arr1, int[] arr2, int n1, int n2) {
        // System.out.println(n1 + " " + n2);
        if(n1 == 0) {
            if(n2 % 2 == 0) {
                int i2 = n2/2, i1;
                i1 = i2-1;
                return (double)(arr2[i1] + arr2[i2])/2;
            }else {
                int mid = n2/2;
                return arr2[mid];
            }
        }

        int start=0, end=n1-1, i1, i2, left=0, right=0;
        int leftMax = 0, rightMin = 0;
        while(start <= end) {
            i1 = (start+end)/2;
            i2 = (n1 + n2 + 1)/2 - i1;

            // System.out.println(i1 + " " + i2);

            // i1-1 can be zero and i2 can be arr2.length
            if(i1-1>=0) {
                leftMax = Math.max(arr1[i1-1], arr2[i2-1]);
            }else {
                leftMax = arr2[i2-1];
            }

            if(i2<arr2.length) {
                rightMin = Math.min(arr1[i1], arr2[i2]);
            }else {
                rightMin = arr1[i1];
            }

            if(leftMax <= rightMin) {
                if((n1+n2) % 2 == 0) {
                    return (double)(leftMax + rightMin)/2;
                }else {
                    return leftMax;
                }
            }
            if(arr1[i1] < leftMax)
                start = i1+1;
            else end = i1-1;
            // System.out.println(start);
        }

        i1 = start;
        i2 = (n1 + n2 + 1)/2 - i1;

        if(i2-1>=0)
            leftMax = Math.max(arr1[i1-1], arr2[i2-1]);
        else leftMax = arr1[i1-1];

        rightMin = arr2[i2];

        if((n1+n2) % 2 == 0) {
            return (double)(leftMax + rightMin)/2;
        }else {
            return leftMax;
        }

    }
}
