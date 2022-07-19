/**
 *
 * Level: Hard
 * refer to: https://www.geeksforgeeks.org/median-of-two-sorted-arrays/?ref=lbp
 *
 * Pseudo Code:
 *      a1 a2 m1 a3 a4
 *      b1 b2 m2 b3 b4
 *
 *      if(m1 == m2)
 *      {a1 a2 b1 b2} m1 m2 {a3 a4 b3 b4}
 *      ans = (m1+m2)/2
 *
 *      if(m1 < m2)
 *      {a1 a2..} m1 {} m2 {..b3 b4}
 *      median(arr1, arr2, m1, a4, b1, m2)
 *
 *      if(m1 > m2)
 *      {b1 b2.. } m2 {} m1 {.. a3 a4}
 *      median(arr1, arr2, a1, m1, m2, b4)
 *
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
 *
 */


public class MedianOfTwoSortedArrayEqualSize {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 7, 9};
        int[] nums2 = {5, 10, 15, 28};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedianEqualSize(nums1, nums2, 0, nums1.length-1, 0, nums2.length-1);
    }

    private static double findMedianEqualSize(int[] arr1, int[] arr2, int start1, int end1, int start2, int end2) {
        int numElems = end1-start1+1;
        // System.out.println(numElems);
        if(numElems == 0) {
            return 0;
        }

        if(numElems == 1) {
            return (double)(arr1[start1] + arr2[start2])/2;
        }

        if(numElems == 2) {
            return (double)(Math.max(arr1[start1], arr2[start2]) + Math.min(arr1[end1], arr2[end2]))/2 ;
        }

        // calculate median
        double m1=(double)(arr1[start1] + arr1[end1])/2;
        double m2=(double)(arr2[start2] + arr1[end2])/2;

        if(m1 == m2) {
            return (m1 + m2)/2;
        }

        int midIndex1, midIndex2;
        if(m1 < m2) {
            midIndex1 = (start1 + end1 + 1)/2;
            midIndex2 = (start2 + end2)/2;
            return findMedianEqualSize(arr1, arr2, midIndex1, end1, start2, midIndex2);
        } else {
            midIndex1 = (start1 + end1)/2;
            midIndex2 = (start2 + end2 + 1)/2;
            return findMedianEqualSize(arr1, arr2, start1, midIndex1, midIndex2, end2);

        }
    }
}